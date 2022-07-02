package com.example.studetsandcourses.service.impl;

;
import com.example.studetsandcourses.dto.StudentDTO;
import com.example.studetsandcourses.entity.Course;
import com.example.studetsandcourses.entity.Student;
import com.example.studetsandcourses.repository.StudentRepository;
import com.example.studetsandcourses.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void create(StudentDTO studentDTO) {
        Student student = Student.builder()
                .name(studentDTO.getName())
                .build();

        studentRepository.save(student);
    }

    @Override
    public StudentDTO findById(Long id) {
        Student student = studentRepository.getById(id);

        Course course = student.getCourse();

        Long courseId = course == null ? null : course.getId();

        // Custom DTO
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .courseId(courseId)
                .build();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> StudentDTO.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .courseId(student.getCourse().getId())
                        .build())
                .collect(Collectors.toList());

    }

}