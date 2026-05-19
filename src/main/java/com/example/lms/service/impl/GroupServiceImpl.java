package com.example.lms.service.impl;

import com.example.lms.dto.GroupDto;
import com.example.lms.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl extends GroupService {
    @Override
    public List<GroupDto> getAllGroups() {
        return List.of();
    }

    @Override
    public GroupDto addGroup(GroupDto dto) {
        return null;
    }

    @Override
    public GroupDto getGroupById(Long id) {
        return null;
    }

    @Override
    public GroupDto updateGroup(Long id, GroupDto dto) {
        return null;
    }

    @Override
    public void deleteGroup(Long id) {

    }
}
