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
    private  Long groupId;
    @NotNull
    private  Long teacherId;
    @NotNull
    private  Long courseId;
    @NotNull
    private  LocalDateTime lessonDate;
}
