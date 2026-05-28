package com.example.lms.dao;

import com.example.lms.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s WHERE s.teacher.id = :teacherId")
    List<Schedule> findByTeacherId(@Param("teacherId") Long teacherId);

    @Query("SELECT COUNT(s) > 0 FROM Schedule s WHERE s.teacher.id = :teacherId AND s.lessonDate = :lessonDate")
    boolean existsScheduleByTeacherAndLessonDate(@Param("teacherId") Long teacherId, @Param("lessonDate")LocalDateTime lessonDate);

}
