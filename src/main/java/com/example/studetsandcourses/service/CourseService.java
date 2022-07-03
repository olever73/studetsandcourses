package com.example.studetsandcourses.service;

import com.example.studetsandcourses.dto.CourseRequestDTO;
import com.example.studetsandcourses.dto.CourseResponseDTO;

public interface CourseService {
    void create(CourseRequestDTO courseDTO);

    CourseResponseDTO getById(Long id);

}
