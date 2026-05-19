package com.example.lms.service.impl;

import com.example.lms.dto.ScheduleDto;
import com.example.lms.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public List<ScheduleDto> getAllSchedules() {
        return List.of();
    }

    @Override
    public ScheduleDto getScheduleById(Long id) {
        return null;
    }

    @Override
    public ScheduleDto addSchedule(ScheduleDto dto) {
        return null;
    }

    @Override
    public ScheduleDto updateSchedule(Long id, ScheduleDto dto) {
        return null;
    }

    @Override
    public void deleteSchedule(Long id) {

    }
}
