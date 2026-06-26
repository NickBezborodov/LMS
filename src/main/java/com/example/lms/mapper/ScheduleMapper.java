package com.example.lms.mapper;

import com.example.lms.dto.ScheduleDto;
import com.example.lms.model.Course;
import com.example.lms.model.Group;
import com.example.lms.model.Schedule;
import com.example.lms.model.Teacher;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    @Mapping(target = "groupId", source = "group.id")
    @Mapping(target = "teacherId", source = "teacher.id")
    @Mapping(target = "courseId", source = "course.id")
    ScheduleDto toDto(Schedule schedule);

    @Mapping(target = "group", source = "groupId")
    @Mapping(target = "teacher", source = "teacherId")
    @Mapping(target = "course", source = "courseId")
    Schedule toEntity(@Valid ScheduleDto dto);

    default Group mapGroup(Long groupId) {
        if(groupId == null) return null;
        Group group = new Group();
        group.setId(groupId);
        return group;
    }

    default Course mapCourse(Long courseId) {
        if(courseId == null) return null;
        Course course = new Course();
        course.setId(courseId);
        return course;
    }

    default Teacher mapTeacher(Long teacherId) {
        if(teacherId == null) return null;
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        return teacher;
    }
}