package com.example.baitapbuoi5.controller;

import com.example.baitapbuoi5.User;
import com.example.baitapbuoi5.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = {"/login", "/"})
    public String showLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        for (User tmp : userRepository.findAll()) {
            if (tmp.getUsername().equals(user.getUsername()) && tmp.getPassword().equals(user.getPassword())) {
                return "redirect:store";
            }
        }
        model.addAttribute("message", "Thông tin đăng nhập không chính xác");
        return "login";
    }

    @GetMapping("/store")
    public String store(Model model) {
        List<User> list = userRepository.findAll();
        model.addAttribute("list", list);
        return "store";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        List<User> list = userRepository.findAll();
        for (User tmp : list) {
            if (user.getUsername().equals(tmp.getUsername())) {
                model.addAttribute("message", "Tên đăng nhập đã tồn tại");
                return "register";
            }
        }
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        User user = userRepository.getById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        return "redirect:/store";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "delete";
    }

    @GetMapping("/delete")
    public String deleteUser(@ModelAttribute(name = "id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/store";
    }


}
