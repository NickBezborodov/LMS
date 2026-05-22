package com.example.lms.controller;

import com.example.lms.dto.TeacherDto;

import com.example.lms.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("api/v1/teachers")
@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDto getSTeacher(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public TeacherDto addTeacher(@Valid @RequestBody TeacherDto dto) {
        return teacherService.addTeacher(dto);
    }

    @PutMapping("/{id}")
    public TeacherDto updateTeacher(@PathVariable Long id, @Valid @RequestBody TeacherDto dto) {
        return teacherService.updateTeacher(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
