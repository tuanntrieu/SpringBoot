package com.example.baitapbuoi9.controller;

import com.example.baitapbuoi9.dto.UserDTO;
import com.example.baitapbuoi9.jwt.JwtUtils;
import com.example.baitapbuoi9.model.User;
import com.example.baitapbuoi9.repositories.RoleRepository;
import com.example.baitapbuoi9.repositories.UserRepository;
import com.example.baitapbuoi9.request.LoginRequest;
import com.example.baitapbuoi9.response.UserResponse;
import com.example.baitapbuoi9.services.UserService;
import com.example.baitapbuoi9.services.imp.UserDetailImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImp userDetailImp = (UserDetailImp) authentication.getPrincipal();
        try {
            String accessToken = jwtUtils.generateTokenByUsername(userDetailImp.getUsername());
            String refreshToken = jwtUtils.generateRefreshTokenByUsername(userDetailImp.getUsername());
            return ResponseEntity.ok(new UserResponse(
                    userDetailImp.getId(),
                    userDetailImp.getFullName(),
                    userDetailImp.getEmail(),
                    userDetailImp.getAddress(),
                    accessToken, refreshToken,
                    userDetailImp.getAuthorities()
            ));
        } catch (Exception e) {
            return ResponseEntity.ok("Login failed : " + e.getMessage());
        }
    }

    @PutMapping("/user/edit_user_by_id/{id}")
    public ResponseEntity<?> editUserById(@PathVariable int id, @Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.editUserById(id, userDTO));
    }

    @PostMapping("/all/create_new_user")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody UserDTO userDTO) {

        return ResponseEntity.ok(userService.createNewUser(userDTO));
    }

    @DeleteMapping("/admin/delete_user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("\n" +
                "success!");
    }

    @GetMapping("/all/get_user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserByID(id));
    }

    @GetMapping("/admin/search_user/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.searchUserByName(name));
    }

    @GetMapping("/admin/getAllUser")
    public ResponseEntity<?> findAllUser(@RequestParam(name = "page", required = false) int page,
                                         @RequestParam(name = "size", required = false, defaultValue = "2") int size) {
        return ResponseEntity.ok(userService.getAllUser(page,size));
    }
}
