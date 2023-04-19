package com.example.buoi6.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Subject() {

    }

    public Subject(int id, String name, Student student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }

    public Subject(int id, Student student) {
        this.id = id;
        this.student = student;
    }


    public Subject(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //FetchType.EAGER load cac doi tuong lien quan den no nua subject co student thi no xuat ca student
    @ManyToOne(fetch = FetchType.EAGER)
    //@JsonBackReference
    @JoinColumn(name = "student_id")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
