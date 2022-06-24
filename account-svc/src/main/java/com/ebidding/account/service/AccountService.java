package com.ebidding.account.service;

import com.ebidding.account.AccountDto;
import com.ebidding.account.LoginResponseDto;
import com.ebidding.account.domain.Account;
import com.ebidding.account.repository.AccountRepository;
import com.ebidding.common.cryto.Hash;
import com.ebidding.common.cryto.Sign;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private static final String SALT = "123456";

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public Account getAccountByName(String name) {
        return this.accountRepository.findByName(name).orElse(null);
    }

    public Optional<LoginResponseDto> login(String username, String password) {
        return this.verifyAccount(username, password)
                .map(accountDto -> {
                    LoginResponseDto user = this.modelMapper.map(accountDto, LoginResponseDto.class);
                    user.setToken(Sign.generateToken(
                            user.getId(),
                            user.getName(),
                            user.getRole(),
                            1000 * 60 * 60 * 24
                    ));
                    return user;
                });
    }

    private Optional<AccountDto> verifyAccount(String username, String password) {
        return this.accountRepository.findByName(username)
                .filter(account -> {
                    try {
                        return Objects.equals(account.getPassword_hash(), Hash.encode(SALT, password));
                    } catch (Exception e) {
                        return false;
                    }
                }).map(account -> this.modelMapper.map(account, AccountDto.class));
    }
}
