package com.example.lms.mapper;

import org.mapstruct.Mapper;
import com.example.lms.dto.StudentDto;
import com.example.lms.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);

    Student toEntity(StudentDto dto);
}

