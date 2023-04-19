package com.example.baitapbuoi6.controller;

import com.example.baitapbuoi6.dto.StudentDTO;
import com.example.baitapbuoi6.model.Student;
import com.example.baitapbuoi6.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/create_student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName(), studentDTO.getAddress());
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping("/viewAllStudent")
    public ResponseEntity<?> viewAllStudent() {
        return ResponseEntity.ok().body(studentRepository.findAll());
    }

}
