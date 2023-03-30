package com.example.btvn_buoi2.controller;

import com.example.btvn_buoi2.model.SinhVien;
import com.example.btvn_buoi2.model.TaiKhoan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {
    @GetMapping("/index")
    public String showLoginForm() {
        return "index";
    }


    public TaiKhoan taiKhoan = new TaiKhoan("taikhoan1", "123");
    @RequestMapping(value="/about", method = RequestMethod.GET)
    public String danhSachSinhVien(Model model) {
        List<SinhVien> danhsach = Arrays.asList(
                new SinhVien("Msv1", "Trieu Dang Tuan", 20, "CNTT"),
                new SinhVien("Msv2", "Pham Trung Tien", 20, "QLKD"),
                new SinhVien("Msv3", "Pham Duc Thang", 19, "CNTT")
        );
        model.addAttribute("danhsach", danhsach);
        return "about";
    }
    @RequestMapping(value = "/about", method = RequestMethod.POST)
    public String about(@RequestParam("tenTK") String tk,@RequestParam("matKhau") String mk, Model model) {

        if (tk.compareTo(taiKhoan.getTenTk()) == 0 && mk.compareTo((taiKhoan.getMatKhau())) == 0){
            return "redirect:about";
        }
       else{
           String s="Tài khoản không hợp lệ";
           model.addAttribute("message",s);
            return "index";
        }

    }

}
