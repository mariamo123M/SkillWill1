package com.example.blog;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min=2, max=32) @Pattern(regexp = "[A-Za-z]+")
    private String firstName;

    @NotBlank @Size(min=2, max=64) @Pattern(regexp = "[A-Za-z]+")
    private String lastName;

    @NotBlank @Size(min=4, max=16) @Pattern(regexp = "[A-Za-z0-9]+")
    @Column(unique = true)
    private String username;

    @NotNull @PastOrPresent
    private LocalDate birthDate;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    // Getters and setters
}
