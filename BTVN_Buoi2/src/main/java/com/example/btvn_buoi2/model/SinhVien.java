package com.example.btvn_buoi2.model;

public class SinhVien {
    private String msv;
    private String ten;
    private int tuoi;
    private String khoa;

    public SinhVien() {
    }

    public SinhVien(String msv, String ten, int tuoi, String khoa) {
        this.msv = msv;
        this.ten = ten;
        this.tuoi = tuoi;
        this.khoa = khoa;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
