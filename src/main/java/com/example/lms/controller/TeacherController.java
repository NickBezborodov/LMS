package com.example.lms.controller;

import com.example.lms.dto.TeacherDto;

import com.example.lms.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("api/v1/teachers")
@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public Page<TeacherDto> getAllTeachers(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return teacherService.getAllTeachers(pageable);
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacher(@PathVariable Long id) {
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
