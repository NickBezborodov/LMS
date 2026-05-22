package com.example.lms.controller;

import com.example.lms.dto.GroupDto;
import com.example.lms.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/groups")
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public List<GroupDto> getAllGroups(){
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupDto getGroup(@PathVariable Long id){
        return groupService.getGroupById(id);
    }

    @PostMapping
    public GroupDto addGroup(@Valid @RequestBody GroupDto dto) {
        return groupService.addGroup(dto);
    }

    @PutMapping("/{id}")
    public GroupDto updateGroup(@PathVariable Long id, @Valid @RequestBody GroupDto dto){
        return groupService.updateGroup(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
         groupService.deleteGroup(id);
    }
}
