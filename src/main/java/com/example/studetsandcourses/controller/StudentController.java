package com.example.studetsandcourses.controller;


import com.example.studetsandcourses.dto.StudentDTO;
import com.example.studetsandcourses.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @PostMapping("/students")
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.create(studentDTO);
    }

    @GetMapping("/students/{id}")
    public StudentDTO findByBy(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

}