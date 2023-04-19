package com.example.baitapbuoi6.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    @OneToOne()
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    public Phone(String name, String brand, Student student) {
        this.name = name;
        this.brand = brand;
        this.student = student;
    }
}
