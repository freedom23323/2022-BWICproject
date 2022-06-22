package com.ebidding.bid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.ebidding.account"})
public class BidApplication {
    public static void main(String[] args) {
        SpringApplication.run(BidApplication.class, args);
    }
}
