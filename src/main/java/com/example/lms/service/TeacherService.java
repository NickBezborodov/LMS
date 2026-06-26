package com.example.lms.service;

import com.example.lms.dto.TeacherDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {

    Page<TeacherDto> getAllTeachers(Pageable pageable);

    TeacherDto addTeacher(TeacherDto dto);

    TeacherDto getTeacherById(Long id);

    TeacherDto updateTeacher(Long id, TeacherDto dto);

    void deleteTeacher(Long id);
}
