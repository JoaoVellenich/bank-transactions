package com.joaovellenich.banktransactions.domain;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
