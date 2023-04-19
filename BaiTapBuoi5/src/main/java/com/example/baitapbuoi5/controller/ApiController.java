package com.example.baitapbuoi5.controller;

import com.example.baitapbuoi5.User;
import com.example.baitapbuoi5.UserRepository;
import com.example.baitapbuoi5.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ApiController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User newUser = userRepository.save(user);
        return ResponseEntity.ok().body(newUser);
    }


    @GetMapping("/api/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user==null){
            throw new NotFoundException("Không tìm thấy người dùng có id là " + id);
        }
        return ResponseEntity.ok().body(user);
    }

    @PatchMapping("/api/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, User user) {
        Optional<User> currentUser = userRepository.findById(id);
        if (user.getUsername() != null) {
            currentUser.get().setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            currentUser.get().setPassword(user.getPassword());
        }
        if (user.getFullname() != null) {
            currentUser.get().setFullname(user.getFullname());
        }
        userRepository.save(currentUser.get());
        return ResponseEntity.ok().body(currentUser.get());
    }

    @PostMapping("api/user/{id}")
    ResponseEntity<?> updateUser1(@PathVariable Long id, User user) {
        Optional<User> currentUser = userRepository.findById(id);
        if (user.getUsername() != null) {
            currentUser.get().setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            currentUser.get().setPassword(user.getPassword());
        }
        if (user.getFullname() != null) {
            currentUser.get().setFullname(user.getFullname());
        }
        userRepository.save(currentUser.get());
        return ResponseEntity.ok().body(currentUser.get());
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/viewAll")
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

}
