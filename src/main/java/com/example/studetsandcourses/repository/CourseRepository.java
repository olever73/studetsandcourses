package com.example.studetsandcourses.repository;

import com.example.studetsandcourses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface CourseRepository extends JpaRepository<Course, Long> {



}
