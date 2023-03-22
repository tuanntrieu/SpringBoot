package com.example.buoi2;

public class Student {
    private String msv;
    private String name;

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String msv, String name) {
        this.msv = msv;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "msv='" + msv + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
