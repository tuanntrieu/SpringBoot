package com.example.ontapbuoi3_4.model;

public class SinhVien {
    private int id;
    private String name;
    private String email;

    private int temp=1;

    public SinhVien() {
        this.id=temp++;
    }

    public SinhVien(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
