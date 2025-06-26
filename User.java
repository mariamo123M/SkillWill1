package com.example.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}