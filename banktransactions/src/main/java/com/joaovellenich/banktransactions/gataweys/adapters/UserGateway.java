package com.joaovellenich.banktransactions.gataweys.adapters;

import com.joaovellenich.banktransactions.domain.User;

import java.math.BigDecimal;

public interface UserGateway {
    User findUserByEmail(String email);
    User findUserByDocument(String document);
    User saveUser(User newUser);
    User findUserById(Long id);
    void updateBalance(Long id, BigDecimal newBalance);
}
