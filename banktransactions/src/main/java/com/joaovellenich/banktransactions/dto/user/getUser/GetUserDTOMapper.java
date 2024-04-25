package com.joaovellenich.banktransactions.dto.user.getUser;

import com.joaovellenich.banktransactions.domain.User;

public class GetUserDTOMapper {
    public GetUserResponseDTO toResponse(User user){
        return GetUserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .userType(user.getUserType())
                .balance(user.getBalance())
                .build();
    }
}
