package com.example.lms.controller;

import com.example.lms.dto.StudentDto;
import com.example.lms.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public Page<StudentDto> getAllStudents(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable) {
        return studentService.getAllStudents(pageable);
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentDto addStudent(@Valid @RequestBody StudentDto dto) {
        return studentService.addStudent(dto);
    }

    @PostMapping("/{studentId}/check-group/{groupId}")
    public boolean checkStudentGroup(@PathVariable Long studentId, @PathVariable Long groupId) {
        return studentService.existsByStudentIdAndGroupId(studentId, groupId);
    }

    @PostMapping("/assign-course")
    public void assignCourse(@RequestParam Long groupId, @RequestParam Long courseId) {
        studentService.assignGroupToCourse(groupId, courseId);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDto dto) {
        return studentService.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
