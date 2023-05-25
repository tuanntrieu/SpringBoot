package com.example.ontapbuoi7.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phoneNumber;

    @OneToMany(mappedBy = "teacher")
    private List<Course> listCourse;

    @ManyToMany(mappedBy = "listTeacher",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student> listStudent=new ArrayList<>();

    public Teacher(String name,String phoneNumber,Student student){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.listStudent.add(student);
    }
}
