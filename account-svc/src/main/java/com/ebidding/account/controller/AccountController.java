package com.ebidding.account.controller;

import com.ebidding.account.AccountDto;
import com.ebidding.account.LoginRequestDto;
import com.ebidding.account.LoginResponseDto;
import com.ebidding.account.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

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
    public ResponseEntity<AccountDto> getAccount(@RequestParam String name) {
        return ResponseEntity.ok(modelMapper.map(this.accountService.getAccountByName(name), AccountDto.class));
    }

    /**
     * POST http://localhost:8080/api/v1/accounts/login
     * {
     * "username": "xx",
     * "password": "xx"
     * }
     * Status == 200, token => Local Storage | Cookie
     * Status == 401,
     * <p>
     * Logout
     * clean  Local Storage | Cookie
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {
        Optional<LoginResponseDto> user = this.accountService.login(request.getUsername(), request.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}