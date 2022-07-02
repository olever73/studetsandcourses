package com.example.studetsandcourses.service.impl;

import com.example.studetsandcourses.dto.CourseDTO;
import com.example.studetsandcourses.entity.Course;
import com.example.studetsandcourses.repository.CourseRepository;
import com.example.studetsandcourses.repository.StudentRepository;
import com.example.studetsandcourses.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository  courseRepository;

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course=courseRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return CourseDTO.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .build();
    }

    }



