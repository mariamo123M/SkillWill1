package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepo.existsById(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        return ResponseEntity.ok(userRepo.save(user));
    }
}