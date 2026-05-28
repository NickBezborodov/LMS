package com.example.lms.service.impl;

import com.example.lms.dao.GroupRepository;
import com.example.lms.dto.GroupDto;
import com.example.lms.exception.CourseNotFoundException;
import com.example.lms.exception.GroupNotFoundException;
import com.example.lms.mapper.GroupMapper;
import com.example.lms.model.Group;
import com.example.lms.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public Page<GroupDto> getAllGroups(Pageable pageable) {
        return groupRepository.findAll(pageable)
                .map(groupMapper::toDto);

    }

    @Override
    @Transactional
    public GroupDto addGroup(GroupDto dto) {
        Group group = groupMapper.toEntity(dto);
        group = groupRepository.save(group);
        return groupMapper.toDto(group);
    }


    @Override
    public GroupDto getGroupById(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException("Группа с id " + id + "не найдена"));
        return groupMapper.toDto(group);
    }

    @Override
    @Transactional
    public GroupDto updateGroup(Long id, GroupDto dto) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException("Группа с id " + id + "не найдена"));
        group.setName(dto.getName());

        group = groupRepository.save(group);
        return groupMapper.toDto(group);
    }

    @Override
    @Transactional
    public void deleteGroup(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException("Группа с id " + id + "не найдена"));
        groupRepository.delete(group);
    }
}
