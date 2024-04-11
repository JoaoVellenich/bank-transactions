package com.joaovellenich.banktransactions.dto.user.createUser;

import com.joaovellenich.banktransactions.domain.UserType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateUserResponseDTO (
        Long id,
        String fuelName,
        String email,
        String document,
        UserType userType,
        BigDecimal balance
){
}
