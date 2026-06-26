package com.example.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentDto(
        @NotBlank(message = "Имя не должно быть пустым")
        @Size(min = 1, message = "Не должно быть меньше 1 символа")
        String firstName,
        @NotBlank(message = "Фамилия не должна быть пустой")
        @Size(min = 1, message = "Не должно быть меньше 1 символа")
        String lastName,
        Long groupId,
        Long id
) {
}