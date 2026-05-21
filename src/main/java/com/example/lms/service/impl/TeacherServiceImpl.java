package com.example.lms.service.impl;

import com.example.lms.dao.TeacherRepository;
import com.example.lms.dto.TeacherDto;
import com.example.lms.exception.StudentNotFoundException;
import com.example.lms.exception.TeacherNotFoundException;
import com.example.lms.mapper.TeacherMapper;
import com.example.lms.model.Course;
import com.example.lms.model.Teacher;
import com.example.lms.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public TeacherDto addTeacher(TeacherDto dto) {
        Teacher teacher = teacherMapper.toEntity(dto);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Учитель с id " + id + " не найден"));
        return teacherMapper.toDto(teacher);
    }

    @Override
    @Transactional
    public TeacherDto updateTeacher(Long id, TeacherDto dto) {
        teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Учитель с id " + id + " не найден"));
        Teacher teacher = teacherMapper.toEntity(dto);
        teacher.setId(id);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    @Transactional
    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Учитель с id " + id + " не найден"));
        teacherRepository.delete(teacher);
    }
}
