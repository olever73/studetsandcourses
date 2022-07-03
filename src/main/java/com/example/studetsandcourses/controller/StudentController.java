package com.example.studetsandcourses.controller;


import com.example.studetsandcourses.dto.StudentRequestDTO;
import com.example.studetsandcourses.dto.StudentResponseDTO;
import com.example.studetsandcourses.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private  StudentService studentService;


    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody StudentRequestDTO studentRequestDTO){
        studentService.create(studentRequestDTO);
    }

    @GetMapping("/students/{id}")
    public StudentResponseDTO getById(@PathVariable("id")Long id){
        return studentService.getById(id);
    }
    @GetMapping("/students")
    public List <StudentResponseDTO> getById(){
        return studentService.getAll();
    }


}

