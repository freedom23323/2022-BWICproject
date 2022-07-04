package com.ebidding.bwic;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(name = "BWIC-service", path = "/api/v1/bwic", url = "${ebidding.bwic-service-endpoint}")
public interface BWICClient {
    @GetMapping(path = "/")
    ResponseEntity<BWICDto> getBWIC(@RequestParam String cusip);
    @GetMapping("value=/ActiveBWIC")
    public List<BWICDto> getBWIC();
    @PostMapping("value=/BWICAdd")
    public BWICDto bwicAdd(@RequestParam("id") Integer id,@RequestParam("cusip") String cusip,
                        @RequestParam("size") Integer size, @RequestParam("startingprice") Integer startingprice,
                        @RequestParam("duedate") Date duedate);
    @DeleteMapping("/deleteBWIC/{id}")
    public void bwicDelete(@RequestParam("id") Integer id);
    @PutMapping("value=/BWICupdate")
    public BWICDto bwicupdate(@RequestParam("id") Integer id,@RequestParam("cusip") String cusip,
                           @RequestParam("size") Integer size, @RequestParam("startingprice") Integer startingprice,
                           @RequestParam("duedate") Date duedate);
}
