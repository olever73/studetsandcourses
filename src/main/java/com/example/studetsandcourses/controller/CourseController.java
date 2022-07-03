package com.example.studetsandcourses.controller;


import com.example.studetsandcourses.dto.CourseRequestDTO;
import com.example.studetsandcourses.dto.CourseResponseDTO;
import com.example.studetsandcourses.service.CourseService;
import liquibase.pro.packaged.H;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

      @PostMapping ("/courses")
      @ResponseStatus(HttpStatus.CREATED)
      public void create(@RequestBody  CourseRequestDTO courseRequestDTO){
          courseService.create(courseRequestDTO);
      }
  @GetMapping ("/courses/{id}")
    public CourseResponseDTO getCourseById(@PathVariable("id") Long id ){
          return courseService.getById(id);
  }

}
