package com.example.lms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    private LocalDateTime lessonStart;
    private LocalDateTime lessonEnd;

}
