package com.example.lms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class ScheduleDto {
    @NotNull
    private final Long groupId;
    @NotNull
    private final Long teacherId;
    @NotNull
    private final Long courseId;
    @NotNull
    private final LocalDateTime lessonDate;
}
