package com.example.studetsandcourses.controller;


import com.example.studetsandcourses.dto.CourseDTO;
import com.example.studetsandcourses.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/{id}")
    public CourseDTO getDogById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

}
