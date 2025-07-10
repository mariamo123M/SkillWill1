package com.example.blogapp.dto;

import jakarta.validation.constraints.*;

public record CommentDto(
        Long id,
        @NotBlank @Size(min = 2, max = 128) String text,
        Long postId,
        String username
) {}