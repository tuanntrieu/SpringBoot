package com.example.baitapbuoi6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)

    private List<Subject> subjects;


    @OneToOne(mappedBy = "student",fetch = FetchType.EAGER)
    @JsonManagedReference
    private Phone phone;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
