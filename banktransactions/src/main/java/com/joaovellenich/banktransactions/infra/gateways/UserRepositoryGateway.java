package com.joaovellenich.banktransactions.infra.gateways;

import com.joaovellenich.banktransactions.domain.User;
import com.joaovellenich.banktransactions.gataweys.adapters.UserGateway;
import com.joaovellenich.banktransactions.infra.persistence.entity.UserEntity;
import com.joaovellenich.banktransactions.infra.persistence.mapper.UserMapper;
import com.joaovellenich.banktransactions.infra.persistence.repository.UserRepository;

import javax.swing.text.html.Option;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserRepositoryGateway(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public User findUserByEmail(String email) {
        var user = this.userRepository.findByEmail(email);
        if(user.isEmpty()){
            return null;
        }
        return this.userMapper.toDomain(user.get());
    }

    @Override
    public User findUserByDocument(String document) {
        var user = this.userRepository.findByDocument(document);
        if(user.isEmpty()){
            return null;
        }
        return this.userMapper.toDomain(user.get());
    }

    @Override
    public User saveUser(User newUser) {
        var userEntity = this.userMapper.toEntity(newUser);
        var savedUser = this.userRepository.save(userEntity);
        return this.userMapper.toDomain(savedUser);
    }
}
