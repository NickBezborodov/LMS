package com.example.lms.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ScheduleDto(
        @NotNull
        Long groupId,
        @NotNull
        Long teacherId,
        @NotNull
        Long courseId,
        @NotNull
        LocalDateTime lessonStart,
        LocalDateTime lessonEnd
) {
}
