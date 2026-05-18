package com.example.lms.service;

import com.example.lms.dto.CourseDto;
import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();

    CourseDto getCourseById(Long id);

    CourseDto addCourse(CourseDto dto);

    CourseDto updateCourse(Long id, CourseDto dto);

    void deleteCourse(Long id);
}