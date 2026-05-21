package com.example.lms.service.impl;

import com.example.lms.dao.ScheduleRepository;
import com.example.lms.dto.ScheduleDto;
import com.example.lms.exception.ScheduleNotFoundException;
import com.example.lms.mapper.ScheduleMapper;
import com.example.lms.model.Schedule;
import com.example.lms.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleDto> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(scheduleMapper::toDto)
                .toList();
    }

    @Override
    public ScheduleDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("Таблица с id " + id + " не найдена"));
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public ScheduleDto addSchedule(ScheduleDto dto) {
        Schedule schedule = scheduleMapper.toEntity(dto);
        schedule = scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    @Transactional
    public ScheduleDto updateSchedule(Long id, ScheduleDto dto) {
        scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("Таблица с id " + id + " не найдена"));
        Schedule schedule = scheduleMapper.toEntity(dto);
        schedule.setId(id);
        schedule = scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("Таблица с id " + id + "не найдена"));
        scheduleRepository.delete(schedule);
    }
}
