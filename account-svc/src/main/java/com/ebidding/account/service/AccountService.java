package com.ebidding.account.service;

import com.ebidding.account.domain.Account;
import com.ebidding.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountByName(String name) {
        return this.accountRepository.findByName(name).orElse(null);
    }
}
