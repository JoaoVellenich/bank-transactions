package com.joaovellenich.banktransactions.dto.user.getUser;

import com.joaovellenich.banktransactions.domain.UserType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record GetUserResponseDTO (
        Long id,
        String fullName,
        String email,
        UserType userType,
        BigDecimal balance
){
}
