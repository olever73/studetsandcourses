package com.example.studetsandcourses.service;


import com.example.studetsandcourses.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    void create(StudentDTO studentDTO);
    StudentDTO findById(Long id);
//    List<StudentDTO> findAllByCourseId(Long courseId);

    // GET Mapping /buildings
    List<StudentDTO> getAllStudents();

}
