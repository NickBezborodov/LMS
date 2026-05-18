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
public class GroupDto {
    @NotBlank(message = "Название группы не должно быть пустым")
    @Size(min = 1, message = "Не должно быть меньше 1 символа")
    private final String name;
}
