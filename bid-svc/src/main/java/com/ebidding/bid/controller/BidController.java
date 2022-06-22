package com.ebidding.bid.controller;

import com.ebidding.account.AccountDto;
import com.ebidding.bid.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bids")
public class BidController {
    @Autowired
    private BidService bidService;

    @GetMapping("/exceptions")
    public ResponseEntity<String> getException() throws IllegalArgumentException {
        throw new IllegalArgumentException("username is not right");
    }

    @GetMapping
    public ResponseEntity<AccountDto> getBid(@RequestParam String name) {
        return ResponseEntity.ok(this.bidService.getBid(name));
    }
}
