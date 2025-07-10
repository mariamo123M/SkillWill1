package com.example.blogapp.controller;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;
import com.example.blogapp.repository.CommentRepository;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentRepository commentRepo;
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public CommentController(CommentRepository commentRepo, PostRepository postRepo, UserRepository userRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestHeader("X-Username") String username,
                                             @Valid @RequestBody CommentDto dto) {
        User user = userRepo.findByUsername(username).orElseThrow();
        Post post = postRepo.findById(dto.postId()).orElseThrow();
        Comment comment = new Comment();
        comment.setText(dto.text());
        comment.setAuthor(user);
        comment.setPost(post);
        Comment saved = commentRepo.save(comment);
        return ResponseEntity.ok(new CommentDto(saved.getId(), saved.getText(), saved.getPost().getId(), saved.getAuthor().getUsername()));
    }

    @GetMapping("/post/{postId}")
    public List<CommentDto> getByPost(@PathVariable Long postId) {
        return commentRepo.findByPost_Id(postId).stream()
                .map(c -> new CommentDto(c.getId(), c.getText(), c.getPost().getId(), c.getAuthor().getUsername()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> update(@RequestHeader("X-Username") String username,
                                             @PathVariable Long id,
                                             @Valid @RequestBody CommentDto dto) {
        Comment comment = commentRepo.findById(id).orElseThrow();
        if (!comment.getAuthor().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }
        comment.setText(dto.text());
        Comment saved = commentRepo.save(comment);
        return ResponseEntity.ok(new CommentDto(saved.getId(), saved.getText(), saved.getPost().getId(), saved.getAuthor().getUsername()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestHeader("X-Username") String username, @PathVariable Long id) {
        Comment comment = commentRepo.findById(id).orElseThrow();
        if (!comment.getAuthor().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }
        commentRepo.delete(comment);
        return ResponseEntity.noContent().build();
    }
}
