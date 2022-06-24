package com.ebidding.account;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String id;

    private String name;

    private String role;

    private String token;
}
