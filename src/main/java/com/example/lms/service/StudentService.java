package com.example.lms.service;

import com.example.lms.dto.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface    StudentService {

    Page<StudentDto> getAllStudents(Pageable pageable);

    StudentDto addStudent(StudentDto dto);

    StudentDto getStudentById(Long id);

    StudentDto updateStudent(Long id, StudentDto dto);

    void deleteStudent(Long id);

    void assignGroupToCourse(Long groupId, Long courseId);

    boolean existsByStudentIdAndGroupId(Long studentId, Long groupId);
}
