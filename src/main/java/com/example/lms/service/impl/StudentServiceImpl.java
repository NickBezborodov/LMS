package com.example.lms.service.impl;

import com.example.lms.dao.ScheduleRepository;
import com.example.lms.dto.StudentDto;
import com.example.lms.model.Student;
import com.example.lms.exception.StudentNotFoundException;
import com.example.lms.mapper.StudentMapper;
import com.example.lms.dao.StudentRepository;
import com.example.lms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ScheduleRepository scheduleRepository;

    @Override
    public Page<StudentDto> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toDto);
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
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());

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

    @Override
    public void assignGroupToCourse(Long groupId, Long courseId) {
        if (!scheduleRepository.existsByGroupIdAndCourseId(groupId, courseId)){
            throw new IllegalArgumentException("Группа " + groupId + " не назначена на этот курс " +courseId);
        }
    }

    @Override
    public boolean existsByStudentIdAndGroupId(Long studentId, Long groupId) {
        return studentRepository.findById(studentId)
                .map(s -> s.getGroup() != null && s.getGroup().getId().equals(groupId))
                .orElse(false);
    }
}
