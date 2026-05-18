package com.example.lms.service;

import com.example.lms.dto.ScheduleDto;
import java.util.List;

public interface ScheduleService {
    List<ScheduleDto> getAllSchedules();

    ScheduleDto getScheduleById(Long id);

    ScheduleDto addSchedule(ScheduleDto dto);

    ScheduleDto updateSchedule(Long id, ScheduleDto dto);

    void deleteSchedule(Long id);
}