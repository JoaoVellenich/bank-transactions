package com.joaovellenich.banktransactions.gataweys.usecases;

import com.joaovellenich.banktransactions.domain.User;
import com.joaovellenich.banktransactions.gataweys.adapters.UserGateway;

public class GetUserUseCase {
    private final UserGateway userGateway;

    public GetUserUseCase(UserGateway userGateway){
        this.userGateway = userGateway;
    }
    public User GetUserUseCase(Long id) throws Exception{
        User findUser = this.userGateway.findUserById(id);
        if(findUser == null){
            throw new Exception("User not found");
        }
        return findUser;
    }
}
