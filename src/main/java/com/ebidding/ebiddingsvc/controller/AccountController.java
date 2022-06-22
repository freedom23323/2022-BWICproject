package com.ebidding.ebiddingsvc.controller;

import com.ebidding.ebiddingsvc.domain.Account;
import com.ebidding.ebiddingsvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/accounts")
/**
 * http://localhost:8080/api/v1/accounts GET
 */
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * GET POST PATCH DELETE
     *
     * @return
     */
    @GetMapping()
    // GET http://localhost:8080/api/v1/accounts
    // GET http://localhost:8080/api/v1/accounts/?name=${name}
    public ResponseEntity<Account> getAccount(@RequestParam String name) {
        return ResponseEntity.ok(this.accountService.getAccountByName(name));
    }
}
