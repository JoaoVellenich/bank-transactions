package com.joaovellenich.banktransactions.infra.controller;

import com.joaovellenich.banktransactions.domain.User;
import com.joaovellenich.banktransactions.dto.user.createUser.CreateUserDTOMapper;
import com.joaovellenich.banktransactions.dto.user.createUser.CreateUserRequestDTO;
import com.joaovellenich.banktransactions.gataweys.usecases.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private CreateUserUseCase createUserUseCase;
    private CreateUserDTOMapper createUserDTOMapper;
    public UsersController(CreateUserUseCase createUserUseCase, CreateUserDTOMapper createUserDTOMapper){
        this.createUserUseCase = createUserUseCase;
        this.createUserDTOMapper = createUserDTOMapper;
    }

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody CreateUserRequestDTO request){
        User newUser = this.createUserDTOMapper.toDomain(request);
        try{
            var savedUser = this.createUserUseCase.createUserUseCase(newUser);
            return ResponseEntity.ok().body(this.createUserDTOMapper.toResponse(savedUser));
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
