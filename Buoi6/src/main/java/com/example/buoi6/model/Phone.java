package com.example.buoi6.model;



import javax.persistence.*;

@Table(name="phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String brand;

    public Phone(){

    }

    public Phone(int id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;
}
