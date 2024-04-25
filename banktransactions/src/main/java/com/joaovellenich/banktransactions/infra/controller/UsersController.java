package com.joaovellenich.banktransactions.infra.controller;

import com.joaovellenich.banktransactions.domain.User;
import com.joaovellenich.banktransactions.dto.user.createUser.CreateUserDTOMapper;
import com.joaovellenich.banktransactions.dto.user.createUser.CreateUserRequestDTO;
import com.joaovellenich.banktransactions.dto.user.getUser.GetUserDTOMapper;
import com.joaovellenich.banktransactions.gataweys.usecases.CreateUserUseCase;
import com.joaovellenich.banktransactions.gataweys.usecases.GetUserUseCase;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final CreateUserUseCase createUserUseCase;
    private final CreateUserDTOMapper createUserDTOMapper;
    private final GetUserUseCase getUserUseCase;
    private final GetUserDTOMapper getUserDTOMapper;
    public UsersController(CreateUserUseCase createUserUseCase, CreateUserDTOMapper createUserDTOMapper, GetUserUseCase getUserUseCase, GetUserDTOMapper getUserDTOMapper){
        this.createUserUseCase = createUserUseCase;
        this.createUserDTOMapper = createUserDTOMapper;
        this.getUserUseCase = getUserUseCase;
        this.getUserDTOMapper = getUserDTOMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        try{
            User user = this.getUserUseCase.GetUserUseCase(id);
            return ResponseEntity.ok().body(this.getUserDTOMapper.toResponse(user));
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
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
