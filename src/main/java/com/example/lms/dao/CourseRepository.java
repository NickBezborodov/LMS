package com.example.lms.dao;

import com.example.lms.model.Course;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CourseRepository extends JpaRepository <Course, Long> {

}
