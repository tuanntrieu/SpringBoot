package com.example.baitapbuoi3.controller;

import com.example.baitapbuoi3.model.User;
import com.example.baitapbuoi3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@Controller
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping(value = {"/login", "/"})
    public String showLogin() {
        return "login";
    }

    @PostMapping(value="/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        for (User tmp : userService.getUser()) {
            if (tmp.getUsername().equals(user.getUsername()) && tmp.getPassword().equals(user.getPassword())) {
                return "redirect:store";
            }
        }
        model.addAttribute("message", "Thông tin đăng nhập không chính xác");
        return "login";
    }

    @GetMapping("/store")
    public String store(Model model) {
        model.addAttribute("list", userService.getUser());
        return "store";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("user")User user,Model model){
        userService.addUser(user);
        model.addAttribute("mess","Đăng ký thành công");
        return"register";
    }
    @GetMapping("/viewAll")
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok().body(userService.getUser());
    }


}
