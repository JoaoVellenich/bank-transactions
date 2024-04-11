package com.joaovellenich.banktransactions.gataweys.usecases;

import com.joaovellenich.banktransactions.domain.User;
import com.joaovellenich.banktransactions.gataweys.adapters.UserGateway;

public class CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCase(UserGateway userGateway){
        this.userGateway = userGateway;
    }
    public User createUserUseCase(User newUser) throws Exception{
        User findByEmail = this.userGateway.findUserByEmail(newUser.getEmail());
        if(findByEmail != null){
            throw new Exception("Found user with this email: " + newUser.getEmail());
        }
        User findByDocument = this.userGateway.findUserByDocument(newUser.getDocument());
        if(findByDocument != null){
            throw new Exception("Found user with this document: " + newUser.getDocument());
        }
        return this.userGateway.saveUser(newUser);
    }
}
