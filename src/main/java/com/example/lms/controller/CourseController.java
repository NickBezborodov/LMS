package com.example.lms.controller;

import com.example.lms.dto.CourseDto;
import com.example.lms.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("api/v1/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public Page<CourseDto> getAllCourses(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return courseService.getAllCourses(pageable);
    }

    @GetMapping("/{id}")
    public CourseDto getCourse(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PostMapping()
    public CourseDto addCourse(@Valid @RequestBody CourseDto dto) {
        return courseService.addCourse(dto);
    }

    @PutMapping("/{id}")
    public CourseDto updateCourse(@PathVariable Long id, @Valid @RequestBody CourseDto dto) {
        return courseService.updateCourse(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
