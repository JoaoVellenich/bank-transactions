package com.joaovellenich.banktransactions.dto.user.createUser;

import com.joaovellenich.banktransactions.domain.User;

public class CreateUserDTOMapper {
    public User toDomain(CreateUserRequestDTO request){
        return User.builder()
                .fuelName(request.fuelName())
                .email(request.email())
                .password(request.password())
                .document(request.document())
                .userType(request.userType())
                .balance(request.balance())
                .build();
    }

    public CreateUserResponseDTO toResponse(User userData){
        return CreateUserResponseDTO.builder()
                .id(userData.getId())
                .fuelName(userData.getFuelName())
                .email(userData.getEmail())
                .document(userData.getDocument())
                .userType(userData.getUserType())
                .balance(userData.getBalance())
                .build();
    }
}
