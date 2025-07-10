package com.example.blogapp.controller;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostController(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @PostMapping
    public ResponseEntity<PostDto> create(@RequestHeader("X-Username") String username,
                                          @Valid @RequestBody PostDto dto) {
        User user = userRepo.findByUsername(username).orElseThrow();
        Post post = new Post();
        post.setText(dto.text());
        post.setAuthor(user);
        Post saved = postRepo.save(post);
        return ResponseEntity.ok(new PostDto(saved.getId(), saved.getText(), user.getUsername()));
    }

    @GetMapping
    public Page<PostDto> all(Pageable pageable) {
        return postRepo.findAll(pageable).map(p -> new PostDto(p.getId(), p.getText(), p.getAuthor().getUsername()));
    }

    @GetMapping("/{id}")
    public PostDto one(@PathVariable Long id) {
        return postRepo.findById(id)
                .map(p -> new PostDto(p.getId(), p.getText(), p.getAuthor().getUsername()))
                .orElseThrow(() -> new NoSuchElementException("Post not found"));
    }

    @GetMapping("/user/{username}")
    public Page<PostDto> byUser(@PathVariable String username, Pageable pageable) {
        return postRepo.findByAuthor_Username(username, pageable)
                .map(p -> new PostDto(p.getId(), p.getText(), p.getAuthor().getUsername()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> update(@RequestHeader("X-Username") String username,
                                          @PathVariable Long id,
                                          @Valid @RequestBody PostDto dto) {
        Post post = postRepo.findById(id).orElseThrow();
        if (!post.getAuthor().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }
        post.setText(dto.text());
        Post saved = postRepo.save(post);
        return ResponseEntity.ok(new PostDto(saved.getId(), saved.getText(), saved.getAuthor().getUsername()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestHeader("X-Username") String username, @PathVariable Long id) {
        Post post = postRepo.findById(id).orElseThrow();
        if (!post.getAuthor().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }
        postRepo.delete(post);
        return ResponseEntity.noContent().build();
    }
}