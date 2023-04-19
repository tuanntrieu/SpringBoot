package com.example.baitapbuoi6.controller;

import com.example.baitapbuoi6.dto.PhoneDTO;
import com.example.baitapbuoi6.model.Phone;
import com.example.baitapbuoi6.model.Student;
import com.example.baitapbuoi6.repository.PhoneRepository;
import com.example.baitapbuoi6.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api/")
public class PhoneController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @PostMapping("/create_phone")
    public ResponseEntity<?> createNewPhone(@RequestBody PhoneDTO phoneDTO){
        Optional<Student> student=studentRepository.findById(phoneDTO.getStudent_id());
        if(student.isEmpty()){
            return ResponseEntity.ok("Not found student with id : " + phoneDTO.getStudent_id());
        }
        Phone phone = new Phone(phoneDTO.getName(), phoneDTO.getBrand(), student.get());
        return ResponseEntity.ok(phoneRepository.save(phone));
    }
    @GetMapping("/viewAllPhone")
    public ResponseEntity<?> getAllSubject() {
        return ResponseEntity.ok(phoneRepository.findAll());
    }

}
