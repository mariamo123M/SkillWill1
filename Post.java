package com.example.blog.entity;

import jakarta.persistence.*;
import com.example.blog.entity.User;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "author_username", nullable = false)
    private User author;

    public Post() {}

    public Post(String text, User author) {
        this.text = text;
        this.author = author;
    }
}