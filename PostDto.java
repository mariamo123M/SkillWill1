package com.example.blogapp.dto;

import jakarta.validation.constraints.*;

public record PostDto(
        Long id,
        @NotBlank @Size(min = 2, max = 512) String text,
        String username
) {}