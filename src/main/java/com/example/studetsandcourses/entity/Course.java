package com.example.studetsandcourses.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_name", unique = true)
    private String courseName;

}