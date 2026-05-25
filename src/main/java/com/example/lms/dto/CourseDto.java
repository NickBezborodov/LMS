package com.example.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class CourseDto {
    @NotBlank(message = "Название курса не должно быть пустым")
    @Size(min = 1, message = "Не должно быть меньше 1 символа")
    private  String name;
    @NotBlank(message = "Описание не должно быть пустым")
    @Size(min = 1, message = "Не должно быть меньше 1 символа")
    private  String description;
    private  Long teacherId;
    private Long id = null;
}
