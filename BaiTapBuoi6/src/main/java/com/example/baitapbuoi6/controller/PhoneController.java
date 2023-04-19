package com.example.baitapbuoi6.controller;

import com.example.baitapbuoi6.dto.PhoneDTO;

import com.example.baitapbuoi6.service.IPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PhoneController {
    @Autowired
    IPhone phoneService;

    @PostMapping("/create_phone")
    public ResponseEntity<?> createNewPhone(@RequestBody PhoneDTO phoneDTO) {

        return ResponseEntity.ok(phoneService.createPhone(phoneDTO));
    }

    @GetMapping("/viewAllPhone")
    public ResponseEntity<?> getAllSubject() {
        return ResponseEntity.ok(phoneService.findAllPhone());
    }

    @PutMapping("/updatePhoneById/{id}")
    public ResponseEntity<?> updatePhoneById(@PathVariable int id, @RequestBody PhoneDTO phoneDTO) {
        return ResponseEntity.ok(phoneService.updatePhoneById(id, phoneDTO));
    }
}
