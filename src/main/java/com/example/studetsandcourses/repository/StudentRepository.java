package com.example.studetsandcourses.repository;


import com.example.studetsandcourses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Query("select new com.example.studentsdemo.domain.StudentDTO(s.studentId, s.name, s.course.id) from Student s where s.course.id = :courseId")
//    List<StudentDTO> findStudentsByCourse(@Param("courseId") Long courseId);
}