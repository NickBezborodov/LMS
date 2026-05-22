package com.example.lms.service.impl;

import com.example.lms.dto.StudentDto;
import com.example.lms.model.Student;
import com.example.lms.exception.StudentNotFoundException;
import com.example.lms.mapper.StudentMapper;
import com.example.lms.dao.StudentRepository;
import com.example.lms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public StudentDto addStudent(StudentDto dto) {
        Student student = studentMapper.toEntity(dto);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Студент с id " + id + " не найден"));
        return studentMapper.toDto(student);
    }

    @Override
    @Transactional
    public StudentDto updateStudent(Long id, StudentDto dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Студент с id " + id + " не найден"));
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());

        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Студент с id " + id + " не найден"));
        studentRepository.delete(student);
    }
}
