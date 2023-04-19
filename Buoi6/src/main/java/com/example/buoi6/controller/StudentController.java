package com.example.buoi6.controller;

import com.example.buoi6.dto.StudentDTO;
import com.example.buoi6.model.Student;
import com.example.buoi6.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/create_new_student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName(), studentDTO.getAddress());
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping("/get_all_student")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok(studentRepository.findAll());
    }
}
