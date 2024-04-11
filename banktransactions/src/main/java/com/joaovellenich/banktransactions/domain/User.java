package com.joaovellenich.banktransactions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String fuelName;
    private String email;
    private String password;
    private String document;
    private UserType userType;
    private BigDecimal balance;
}
