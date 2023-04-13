package com.example.buoi5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private  UserResponsitory userResponsitory;
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        User userCreate= userResponsitory.save(user);
        return ResponseEntity.ok().body(userResponsitory.save(userCreate));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<User> user=userResponsitory.findById(id);
        return  ResponseEntity.ok().body(user.get());
    }

}
