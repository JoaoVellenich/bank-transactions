package com.joaovellenich.banktransactions.infra.persistence.mapper;

import com.joaovellenich.banktransactions.domain.User;
import com.joaovellenich.banktransactions.infra.persistence.entity.UserEntity;

public class UserMapper {
    public User toDomain(UserEntity userEntity){
        return User.builder()
                .id(userEntity.getId())
                .fullName(userEntity.getFullName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .document(userEntity.getDocument())
                .userType(userEntity.getUserType())
                .balance(userEntity.getBalance())
                .build();
    }

    public UserEntity toEntity(User userDomain){
        return UserEntity.builder()
                .id(userDomain.getId())
                .fullName(userDomain.getFullName())
                .email(userDomain.getEmail())
                .password(userDomain.getPassword())
                .document(userDomain.getDocument())
                .userType(userDomain.getUserType())
                .balance(userDomain.getBalance())
                .build();
    }
}
