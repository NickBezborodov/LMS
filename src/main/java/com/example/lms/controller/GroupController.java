package com.example.lms.controller;

import com.example.lms.dto.GroupDto;
import com.example.lms.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/groups")
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public Page<GroupDto> getAllGroups(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return groupService.getAllGroups(pageable);
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
