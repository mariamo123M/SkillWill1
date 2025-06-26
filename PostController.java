package com.example.blog.controller;

import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestParam String username, @RequestBody String text) {
        Optional<User> userOpt = userRepo.findById(username);
        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }
        Post post = new Post(text, userOpt.get());
        return ResponseEntity.ok(postRepo.save(post));
    }
}