package com.ebidding.account.config;

import com.ebidding.common.config.EBiddingConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(EBiddingConfig.class)
public class AccountConfiguration {
}
