package com.example.codebuoi9.controller;

import com.example.codebuoi9.dto.UserDTO;
import com.example.codebuoi9.enums.EnumRole;
import com.example.codebuoi9.model.Role;
import com.example.codebuoi9.model.User;
import com.example.codebuoi9.repo.RoleRepository;
import com.example.codebuoi9.repo.UserRepository;
import com.example.codebuoi9.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create_new_user")
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role role = roleRepository.findRoleByRoleName(EnumRole.ROLE_USER);
        user.setRole(role);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/user/get_user/{id}")
    public  ResponseEntity<?> getUserById(@PathVariable("id") int id){
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()) {
            return ResponseEntity.ok("User not found with id : " + id);
        }
        return ResponseEntity.ok(findUser.get());
    }


    @GetMapping("/admin/get_all_user")
    public  ResponseEntity<?> findAllUser(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok().build();
    }
}
