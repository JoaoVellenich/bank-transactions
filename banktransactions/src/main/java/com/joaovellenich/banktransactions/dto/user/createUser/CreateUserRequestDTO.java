package com.joaovellenich.banktransactions.dto.user.createUser;

import com.joaovellenich.banktransactions.domain.UserType;

import java.math.BigDecimal;

public record CreateUserRequestDTO (
        String fuelName,
        String email,
        String password,
        String document,
        UserType userType,
        BigDecimal balance
){
}
