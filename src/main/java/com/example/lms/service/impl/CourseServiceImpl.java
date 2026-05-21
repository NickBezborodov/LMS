package com.example.lms.service.impl;

import com.example.lms.dao.CourseRepository;
import com.example.lms.dto.CourseDto;
import com.example.lms.exception.CourseNotFoundException;
import com.example.lms.exception.StudentNotFoundException;
import com.example.lms.mapper.CourseMapper;
import com.example.lms.model.Course;
import com.example.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .toList();
    }

    @Override
    public CourseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Курс с id " + id + " не найден"));
        return courseMapper.toDto(course);
    }

    @Override
    @Transactional
    public CourseDto addCourse(CourseDto dto) {
        Course course = courseMapper.toEntity(dto);
        course = courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    @Override
    @Transactional
    public CourseDto updateCourse(Long id, CourseDto dto) {
        courseRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Курс с id " + id + " не найден"));
        Course course = courseMapper.toEntity(dto);
        course.setId(id);
        course = courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Курс с id " + id + " не найден"));
        courseRepository.delete(course);
    }
}
