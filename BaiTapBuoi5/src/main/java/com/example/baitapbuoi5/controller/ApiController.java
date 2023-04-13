package com.example.baitapbuoi5.controller;

import com.example.baitapbuoi5.User;
import com.example.baitapbuoi5.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ApiController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/viewAll")
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

}
