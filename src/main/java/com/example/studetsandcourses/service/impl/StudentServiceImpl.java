package com.example.studetsandcourses.service.impl;

;
import com.example.studetsandcourses.dto.CourseRequestDTO;
import com.example.studetsandcourses.dto.StudentRequestDTO;
import com.example.studetsandcourses.dto.StudentResponseDTO;
import com.example.studetsandcourses.entity.Course;
import com.example.studetsandcourses.entity.Student;
import com.example.studetsandcourses.entity.StudentCourse;
import com.example.studetsandcourses.repository.CourseRepository;
import com.example.studetsandcourses.repository.StudentCourseRepository;
import com.example.studetsandcourses.repository.StudentRepository;
import com.example.studetsandcourses.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;
    @Override
    public void create(StudentRequestDTO studentDTO) {
        Student student=Student.builder()
                .name(studentDTO.getName())
                .build();
        studentRepository.save(student);

    }

    @Override
    public List<StudentResponseDTO> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(student -> StudentResponseDTO.builder()
                        .name(student.getName())
                        .build())
                        .collect(Collectors.toList());

    }



    @Override
    public StudentResponseDTO getById(Long id) {
        Student student=studentRepository.findById(id)
                .orElseThrow(()->
        new  ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("Student with id %s does not exist", id)));

        List<Long> coursesIdByStudentId = getCoursesByStudentId(id);
        List<Course> courses = coursesIdByStudentId.stream()
                .map(courseId->courseRepository.findById(courseId)
                        .orElseThrow(()->
                                new  ResponseStatusException(
                                        HttpStatus.NOT_FOUND,
                                        String.format("Student with id %s does not exist", id))))
                        .collect(Collectors.toList());

        return convertStudentToDto(student, courses);
    }



    private List<Long> getCoursesByStudentId(Long id) {
         return studentCourseRepository.findAllByStudentId(id).stream()
                 .map(StudentCourse::getCourseId)
                 .collect(Collectors.toList());

    }
    private StudentResponseDTO convertStudentToDto(Student student, List<Course> courses) {
        return StudentResponseDTO.builder()
                .name(student.getName())
                .courses(courses.stream()
                        .map(course-> CourseRequestDTO.builder()
                                .courseName(course.getCourseName())
                        .build())
                        .collect(Collectors.toList()))
                .build();
    }

}