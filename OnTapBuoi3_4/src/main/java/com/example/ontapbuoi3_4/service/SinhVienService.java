package com.example.ontapbuoi3_4.service;

import com.example.ontapbuoi3_4.model.SinhVien;

import java.util.List;

public interface SinhVienService {
    List<SinhVien> danhSachSv();

    SinhVien getById();

    void add(SinhVien sinhVien);

    void edit(SinhVien sinhVien);


}
