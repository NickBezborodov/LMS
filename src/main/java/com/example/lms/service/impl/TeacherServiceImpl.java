package com.example.lms.service.impl;

import com.example.lms.dao.TeacherRepository;
import com.example.lms.dto.TeacherDto;
import com.example.lms.exception.TeacherNotFoundException;
import com.example.lms.mapper.TeacherMapper;
import com.example.lms.model.Teacher;
import com.example.lms.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public Page<TeacherDto> getAllTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable)
                .map(teacherMapper::toDto);
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
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Учитель с id " + id + " не найден"));
        teacher.setFirstName(dto.firstName());
        teacher.setLastName(dto.lastName());

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
