package com.example.lms.service;

import com.example.lms.dto.ScheduleDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScheduleService {
    Page<ScheduleDto> getAllSchedules(Pageable pageable);

    ScheduleDto getScheduleById(Long id);

    ScheduleDto addSchedule(@Valid ScheduleDto dto);

    ScheduleDto updateSchedule(Long id, ScheduleDto dto);

    void deleteSchedule(Long id);
}