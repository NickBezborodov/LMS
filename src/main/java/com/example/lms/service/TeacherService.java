package com.example.lms.service;


import com.example.lms.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeachers();

    TeacherDto addTeacher(TeacherDto dto);

    TeacherDto getTeacherById(Long id);

    TeacherDto updateTeacher(Long id, TeacherDto dto);

    void deleteTeacher(Long id);
}
