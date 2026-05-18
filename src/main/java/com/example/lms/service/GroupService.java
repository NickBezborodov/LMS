package com.example.lms.service;

import com.example.lms.dto.GroupDto;

import java.util.List;

public interface GroupService {
    List<GroupDto> getAllGroups();

    GroupDto addGroup(GroupDto dto);

    GroupDto getGroupById(Long id);

    GroupDto updateGroup(Long id, GroupDto dto);

    void deleteGroup(Long id);
}
