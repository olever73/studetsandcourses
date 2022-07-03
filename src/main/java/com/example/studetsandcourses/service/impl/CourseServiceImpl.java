package com.example.studetsandcourses.service.impl;

import com.example.studetsandcourses.dto.CourseRequestDTO;
import com.example.studetsandcourses.dto.CourseResponseDTO;
import com.example.studetsandcourses.entity.Course;
import com.example.studetsandcourses.repository.CourseRepository;
import com.example.studetsandcourses.repository.StudentCourseRepository;
import com.example.studetsandcourses.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public void create(CourseRequestDTO courseDTO) {
        Course course =Course.builder()
                .courseName(courseDTO.getCourseName())
                .build();
        courseRepository.save(course);
    }

    @Override
    public CourseResponseDTO getById(Long id) {
        Long count =studentCourseRepository.countAllByCourseId(id);
        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                String.format("Course with %s does not exit",id))
                        );
        return CourseResponseDTO.builder()
                .courseName(course.getCourseName())
                .studentsCount(count)
                .build();
    }
}



