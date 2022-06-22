package com.ebidding.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Data Transfer Object
public class AccountDto {
    private String id;

    private String name;

    private String role;
}
