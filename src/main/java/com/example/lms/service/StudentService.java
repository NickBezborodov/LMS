package com.example.lms.service;

import com.example.lms.dto.StudentDto;

import java.util.List;

public interface    StudentService {

    List<StudentDto> getAllStudents();

    StudentDto addStudent(StudentDto dto);

    StudentDto getStudentById(Long id);

    StudentDto updateStudent(Long id, StudentDto dto);

    void deleteStudent(Long id);
}
