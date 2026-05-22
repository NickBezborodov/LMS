package com.example.lms.controller;

import com.example.lms.dto.CourseDto;
import com.example.lms.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("api/v1/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List <CourseDto> getAllCourses(){
        return courseService.getAllCourses();
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
