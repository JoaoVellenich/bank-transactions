package com.joaovellenich.banktransactions.gataweys.adapters;

import com.joaovellenich.banktransactions.domain.User;

public interface UserGateway {
    User findUserByEmail(String email);
    User findUserByDocument(String document);
    User saveUser(User newUser);
    User findUserById(Long id);
    User updateUser(User updatedUser);
}
