package com.example.lms.mapper;

import com.example.lms.dto.CourseDto;
import com.example.lms.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(Course course);
    Course toEntity(CourseDto dto);
}