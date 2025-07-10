package com.example.blogapp.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record UserDto(
        @NotBlank @Size(min = 2, max = 32) @Pattern(regexp = "[A-Za-z]+") String firstName,
        @NotBlank @Size(min = 2, max = 64) @Pattern(regexp = "[A-Za-z]+") String lastName,
        @NotBlank @Size(min = 4, max = 16) @Pattern(regexp = "[A-Za-z0-9]+") String username,
        @NotNull @PastOrPresent LocalDate birthDate
) {}