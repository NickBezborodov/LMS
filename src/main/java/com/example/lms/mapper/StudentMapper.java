package com.example.lms.mapper;

import com.example.lms.model.Group;
import org.mapstruct.Mapper;
import com.example.lms.dto.StudentDto;
import com.example.lms.model.Student;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "groupId", source = "group.id")
    StudentDto toDto(Student student);

    @Mapping(target = "group", source = "groupId")
    Student toEntity(StudentDto dto);

    default Group mapGroup(Long groupId) {
        if (groupId == null) return null;
        Group group = new Group();
        group.setId(groupId);
        return group;
    }
}

