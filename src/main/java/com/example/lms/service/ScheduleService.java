package com.example.lms.service;


import com.example.lms.dto.GroupDto;
import com.example.lms.dto.ScheduleDto;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ScheduleService {
    List<ScheduleDto> getAllSchedules();

    ScheduleDto getScheduleById(Long id);

    ScheduleDto addSchedule(@Valid ScheduleDto dto);

    ScheduleDto updateSchedule(Long id, ScheduleDto dto);

    void deleteSchedule(Long id);
}