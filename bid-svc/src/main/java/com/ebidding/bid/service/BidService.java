package com.ebidding.bid.service;

import com.ebidding.account.AccountDto;
import com.ebidding.account.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {
    @Autowired
    private AccountClient accountClient;

    public AccountDto getBid(String name) {
        // => Accounts
        // GET http://localhost:8080/api/v1/accounts/?name=${name}
        // 1. HttpClient => GET http://localhost:8080/api/v1/accounts/?name=${name}
        // Request Params
        // 2. open feign
        return this.accountClient.getAccount(name).getBody();
    }
}
