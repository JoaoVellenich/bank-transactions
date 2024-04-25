package com.joaovellenich.banktransactions.domain;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class User {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String document;
    private UserType userType;
    private BigDecimal balance;
}
