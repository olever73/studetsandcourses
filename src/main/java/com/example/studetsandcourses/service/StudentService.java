package com.example.studetsandcourses.service;




import com.example.studetsandcourses.dto.StudentRequestDTO;
import com.example.studetsandcourses.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    void create(StudentRequestDTO studentDTO);

    List<StudentResponseDTO> getAll();

    StudentResponseDTO getById(Long id);

}
