package com.example.lms.mapper;

import com.example.lms.dto.CourseDto;
import com.example.lms.model.Course;
import com.example.lms.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "teacherId", source = "teacher.id")
    CourseDto toDto(Course course);

    @Mapping(target = "teacher", source = "teacherId")
    Course toEntity(CourseDto dto);

    default Teacher mapTeacher(Long teacherId) {
        if (teacherId == null) return null;
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        return teacher;
    }
}