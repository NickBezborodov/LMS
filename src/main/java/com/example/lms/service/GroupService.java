package com.example.lms.service;

import com.example.lms.dto.GroupDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    Page<GroupDto> getAllGroups(Pageable pageable);

    GroupDto addGroup(GroupDto dto);

    GroupDto getGroupById(Long id);

    GroupDto updateGroup(Long id, GroupDto dto);

    void deleteGroup(Long id);
}
