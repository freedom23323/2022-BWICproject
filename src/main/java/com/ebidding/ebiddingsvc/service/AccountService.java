package com.ebidding.ebiddingsvc.service;

import com.ebidding.ebiddingsvc.domain.Account;
import com.ebidding.ebiddingsvc.repository.AccountRepository;
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
