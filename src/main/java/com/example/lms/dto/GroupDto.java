package com.example.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GroupDto(
        @NotBlank(message = "Название группы не должно быть пустым")
        @Size(min = 1, message = "Не должно быть меньше 1 символа")
        String name,
        Long id
) {
}
