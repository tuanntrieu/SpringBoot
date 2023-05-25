package com.example.ontapbuoi7.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "listCourse",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student>listStudent;

    @ManyToOne
    @JoinColumn(name="teacher_id",referencedColumnName = "id")
    private Teacher teacher;
}
