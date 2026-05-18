package com.example.lms.mapper;

import com.example.lms.dto.GroupDto;
import com.example.lms.model.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDto toDto(Group group);
    Group toEntity(GroupDto dto);
}
