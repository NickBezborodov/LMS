package com.example.lms.mapper;

import com.example.lms.dto.TeacherDto;
import com.example.lms.model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto toDto(Teacher teacher);
    Teacher toEntity(TeacherDto dto);
}
