package com.example.lms.service.impl;

import com.example.lms.dao.GroupRepository;
import com.example.lms.dto.GroupDto;
import com.example.lms.exception.CourseNotFoundException;
import com.example.lms.exception.GroupNotFoundException;
import com.example.lms.mapper.GroupMapper;
import com.example.lms.model.Group;
import com.example.lms.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public List<GroupDto> getAllGroups() {
        return groupRepository.findAll().stream()
                .map(groupMapper::toDto)
                .toList();
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
        groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException("Группа с id " + id + "не найдена"));
        Group group = groupMapper.toEntity(dto);
        group.setId(id);
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
