package com.example.btvn_buoi2.model;

public class TaiKhoan {
    private String tenTk;
    private String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTk, String matKhau) {
        this.tenTk = tenTk;
        this.matKhau = matKhau;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

}
