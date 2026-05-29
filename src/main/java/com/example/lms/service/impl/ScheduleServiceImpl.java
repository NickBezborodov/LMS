package com.example.lms.service.impl;

import com.example.lms.dao.CourseRepository;
import com.example.lms.dao.GroupRepository;
import com.example.lms.dao.ScheduleRepository;
import com.example.lms.dao.TeacherRepository;
import com.example.lms.dto.ScheduleDto;
import com.example.lms.exception.CourseNotFoundException;
import com.example.lms.exception.GroupNotFoundException;
import com.example.lms.exception.ScheduleNotFoundException;
import com.example.lms.exception.TeacherNotFoundException;
import com.example.lms.mapper.ScheduleMapper;
import com.example.lms.model.Schedule;
import com.example.lms.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @Override
    public Page<ScheduleDto> getAllSchedules(Pageable pageable) {
        return scheduleRepository.findAll(pageable)
                .map(scheduleMapper::toDto);
    }

    @Override
    public ScheduleDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("Таблица с id " + id + " не найдена"));
        return scheduleMapper.toDto(schedule);
    }

    @Override
    @Transactional
    public ScheduleDto addSchedule(@Valid ScheduleDto dto) {
        if (scheduleRepository.existsOverlappingSchedule(dto.teacherId(), dto.lessonStart(), dto.lessonEnd())) {
            throw new IllegalArgumentException("Учитель занят в это время.");
        }

        Schedule schedule = scheduleMapper.toEntity(dto);
        schedule = scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    @Transactional
    public ScheduleDto updateSchedule(Long id, ScheduleDto dto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("Таблица с id " + id + " не найдена"));

        if (scheduleRepository.existsOverlappingSchedule(dto.teacherId(), dto.lessonStart(), dto.lessonEnd())) {
            throw new IllegalArgumentException("Учитель занят в это время.");
        }

        schedule.setGroup(groupRepository.findById(dto.groupId()).orElseThrow(() -> new GroupNotFoundException
                ("Группа с id " + dto.groupId() + " не найдена")));
        schedule.setTeacher(teacherRepository.findById(dto.teacherId()).orElseThrow(() -> new TeacherNotFoundException
                ("Учитель с id " + dto.teacherId() + " не найден")));
        schedule.setCourse(courseRepository.findById(dto.courseId()).orElseThrow(() -> new CourseNotFoundException
                ("Курс с id " + dto.courseId() + " не найден")));
        schedule.setLessonStart(dto.lessonStart());
        schedule.setLessonEnd(dto.lessonEnd());

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
