package com.example.lms.service.impl;

import com.example.lms.dao.CourseRepository;
import com.example.lms.dto.CourseDto;
import com.example.lms.exception.CourseNotFoundException;
import com.example.lms.mapper.CourseMapper;
import com.example.lms.model.Course;
import com.example.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    @Override
    public Page<CourseDto> getAllCourses(Pageable pageable) {
        return courseRepository.findAll(pageable)
                .map(courseMapper::toDto);
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
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Курс с id " + id + " не найден"));
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());

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
