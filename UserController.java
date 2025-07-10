package com.example.blogapp.controller;

import com.example.blogapp.dto.UserDto;
import com.example.blogapp.entity.User;
import com.example.blogapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto dto) {
        User user = new User();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setUsername(dto.username());
        user.setBirthDate(dto.birthDate());
        userRepo.save(user);
        return ResponseEntity.ok(dto);
    }
}