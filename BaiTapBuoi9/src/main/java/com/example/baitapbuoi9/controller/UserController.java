package com.example.baitapbuoi9.controller;

import com.example.baitapbuoi9.jwt.JwtUtils;
import com.example.baitapbuoi9.repositories.RoleRepository;
import com.example.baitapbuoi9.repositories.UserRepository;
import com.example.baitapbuoi9.request.LoginRequest;
import com.example.baitapbuoi9.response.UserResponse;
import com.example.baitapbuoi9.services.imp.UserDetailImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImp userDetailImp = (UserDetailImp) authentication.getPrincipal();
        try {
            String accessToken = jwtUtils.generateTokenByUsername(userDetailImp.getUsername());
            return ResponseEntity.ok(new UserResponse(
                    userDetailImp.getId(),
                    userDetailImp.getFullName(),
                    userDetailImp.getEmail(),
                    userDetailImp.getAddress(),
                    accessToken,
                    userDetailImp.getAuthorities()
            ));
        } catch (Exception e) {
            return ResponseEntity.ok("Login failed : " + e.getMessage());
        }
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<?> findAllUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
