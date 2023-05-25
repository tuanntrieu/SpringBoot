package com.example.ontapbuoi7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    private String photo;

    @ManyToMany
    @JoinTable(name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_id",referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"))
    private List<Teacher> listTeacher;

    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"))
    private List<Course> listCourse;

}
