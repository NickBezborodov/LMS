package com.example.lms.controller;


import com.example.lms.dto.ScheduleDto;
import com.example.lms.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("api/v1/schedules")
@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping
    public Page<ScheduleDto> getAllSchedules(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return scheduleService.getAllSchedules(pageable);
    }

    @GetMapping("/{id}")
    public ScheduleDto getSchedule(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    @PostMapping
    public ScheduleDto addSchedule(@Valid @RequestBody ScheduleDto dto){
        return scheduleService.addSchedule(dto);
    }

    @PutMapping("/{id}")
    public ScheduleDto updateSchedule(@PathVariable Long id, @Valid @RequestBody ScheduleDto dto) {
        return scheduleService.updateSchedule(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
    }
}
