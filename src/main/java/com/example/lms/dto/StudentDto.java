package com.example.lms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class StudentDto {
    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 1, message = "Не должно быть меньше 1 символа")
    private String firstName;
    @NotBlank(message = "Фамилия не должна быть пустой")
    @Size(min = 1, message = "Не должно быть меньше 1 символа")
    private  String lastName;
    private Long groupId;
    private Long id;
}