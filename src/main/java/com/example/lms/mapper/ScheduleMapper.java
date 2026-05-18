
package com.example.lms.mapper;

import com.example.lms.dto.ScheduleDto;
import com.example.lms.model.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleDto toDto(Schedule schedule);
    Schedule toEntity(ScheduleDto dto);
}