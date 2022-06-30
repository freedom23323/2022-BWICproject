package com.ebidding.BWIC.controller;

import com.ebidding.BWIC.domain.BWIC;
import com.ebidding.BWIC.service.BWICService;
import com.ebidding.bwic.BWICDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/bwic")
public class BWICController {
    @Autowired
    private BWICService bwicService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * GET POST PATCH DELETE
     *
     * @return
     */
    @GetMapping()
    // GET http://localhost:8080/api/v1/accounts
    // GET http://localhost:8080/api/v1/accounts/?name=${name}
    public ResponseEntity<BWICDto> getBWIC(@RequestParam String cusip) {
        return ResponseEntity.ok(modelMapper.map(this.bwicService.getBWICByCusip(cusip), BWICDto.class));
    }

    @GetMapping("value=/BWICcable")
    // GET http://localhost:8080/api/v1/accounts
    // GET http://localhost:8080/api/v1/accounts/?name=${name}
    public Boolean BWICcable(@RequestParam Integer bwic_id) {
         if(this.bwicService.findBWICcable(bwic_id)==null)return false;
         return true;
    }

    @GetMapping("value=/ActiveBWIC")
    public List<BWIC> getBWIC() {
        return modelMapper.map(bwicService.findBWICActive(),new TypeToken<List<BWIC>>() {}.getType());
    }

    @PostMapping("value=/BWICAdd")
    public BWIC bwicAdd(@RequestParam("cusip") String cusip,
                           @RequestParam("size") Integer size, @RequestParam("startingprice") Integer startingprice,
                           @RequestParam("duedate") Date duedate) {
        BWIC bwic=new BWIC();
        //bwic.setId(id);
        bwic.setCusip(cusip);
        bwic.setSize(size);
        bwic.setStartingprice(startingprice);
        bwic.setDuedate(duedate);
        return bwicService.save(bwic);
    }
    //删除数据
    @DeleteMapping("/deleteBWIC/{id}")
    public void bwicDelete(@RequestParam("id") Integer id) {
        BWIC bwic=new BWIC();
        bwic.setId(id);
        bwicService.delete(bwic);
    }

    //更改数据
    @PutMapping("value=/BWICupdate")
    public BWIC bwicupdate(@RequestParam("id") Integer id,@RequestParam("cusip") String cusip,
                        @RequestParam("size") Integer size, @RequestParam("startingprice") Integer startingprice,
                        @RequestParam("duedate") Date duedate) {
        /*BWIC bwic=new BWIC();
        bwic.setId(cusip);
        bwicService.delete(bwic);*/
        BWIC bwic1=new BWIC();
        bwic1.setId(id);
        bwic1.setCusip(cusip);
        bwic1.setSize(size);
        bwic1.setStartingprice(startingprice);
        bwic1.setDuedate(duedate);
        return bwicService.save(bwic1);
    }

    //日期格式进行转换
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
