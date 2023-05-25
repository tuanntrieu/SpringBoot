package com.example.buoi7.controller;

import com.example.buoi7.dto.UserDTO;
import com.example.buoi7.service.UserService;
import com.example.buoi7.utlts.UploadFileCloudinary;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/api/createUser")
    public ResponseEntity<?> createUser(@RequestParam String name, @RequestParam String address, @RequestParam MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok(userService.create(name, address, multipartFile));
    }

    @PostMapping("/api/createUser2")
    public ResponseEntity<?>createNewUser(@Valid @ModelAttribute UserDTO userDTO ,
                                          BindingResult bindingResult)
            throws IOException {
        //neu co loi thi cho vao Map
        if(bindingResult.hasErrors()){
            Map<String, String> errors= new HashMap<>();

            //loc cai loi, li do
            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            String errorMsg= "";
            //tra ra loi
            for(String key: errors.keySet()){
                errorMsg+= "Lỗi ở: " + key + ", lí do: " + errors.get(key) + "\n";
            }
            return ResponseEntity.ok(errorMsg);
        }
        return ResponseEntity.ok(userService.create2(userDTO));
    }

    @PostMapping("/api/createUser3")
    public ResponseEntity<?> createUser3(@RequestParam String name, @RequestParam String address, @RequestParam MultipartFile multipartFile){
        return ResponseEntity.ok(userService.createNewUser3(name, address, multipartFile));
    }
    @Autowired
    UploadFileCloudinary uploadFileCloudinary;
    @DeleteMapping("/api/delete")
    public ResponseEntity<?>deleteImg(@RequestParam String url) throws Exception {
        return ResponseEntity.ok(uploadFileCloudinary.removeFileToUrl(url));
    }
}
