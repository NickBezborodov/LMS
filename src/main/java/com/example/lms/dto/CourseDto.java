package com.example.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourseDto(
        @NotBlank(message = "Название курса не должно быть пустым")
        @Size(min = 1, message = "Не должно быть меньше 1 символа")
        String name,
        @NotBlank(message = "Описание не должно быть пустым")
        @Size(min = 1, message = "Не должно быть меньше 1 символа")
        String description,
        Long teacherId,
        Long id
) {
}
