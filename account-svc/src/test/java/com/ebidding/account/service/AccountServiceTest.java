package com.ebidding.account.service;

import com.ebidding.account.domain.Account;
import com.ebidding.account.domain.AccountRole;
import com.ebidding.account.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {
    @Test
    public void TestGetAccountByName() {
        // 1. 数据准备
        String name = "test-client";
        // mock 接口
        AccountRepository mockedAccountRepository = mock(AccountRepository.class);
        when(mockedAccountRepository.findByName("test-client"))
                .thenReturn(Optional.of(Account.builder()
                        .id("1")
                        .name(name)
                        .role(AccountRole.CLIENT)
                        .build()));
        // 实例化了测试对象
        AccountService accountService = new AccountService(mockedAccountRepository, new ModelMapper());

        // 2. 执行方法
        Account user = accountService.getAccountByName(name);

        // 3. 验证结果
        Assert.assertEquals(name, user.getName());
    }
}
