package com.example.blog;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min=2, max=128)
    private String text;

    @ManyToOne(optional = false)
    private Post post;

    @ManyToOne(optional = false)
    private User author;

    // Getters and setters
}
