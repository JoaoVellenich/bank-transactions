package com.joaovellenich.banktransactions.config;

import com.joaovellenich.banktransactions.dto.user.createUser.CreateUserDTOMapper;
import com.joaovellenich.banktransactions.gataweys.adapters.UserGateway;
import com.joaovellenich.banktransactions.gataweys.usecases.CreateUserUseCase;
import com.joaovellenich.banktransactions.infra.gateways.UserRepositoryGateway;
import com.joaovellenich.banktransactions.infra.persistence.mapper.UserMapper;
import com.joaovellenich.banktransactions.infra.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway){
        return new CreateUserUseCase(userGateway);
    }
    @Bean
    public UserGateway userGateway(UserRepository userRepository, UserMapper userMapper){
        return new UserRepositoryGateway(userRepository, userMapper);
    }
    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }
    @Bean
    public CreateUserDTOMapper createUserDTOMapper(){
        return new CreateUserDTOMapper();
    }
}
