package com.example.ontapbuoi7.controller;

import com.example.ontapbuoi7.dto.StudentDTO;
import com.example.ontapbuoi7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/api/")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/createStudent")
    public ResponseEntity<?> createStudent(@ModelAttribute StudentDTO studentDTO) throws Exception {
        return ResponseEntity.ok(studentService.create(studentDTO));
    }

    @GetMapping("/findAllStudent")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("successful delete");
    }

    @DeleteMapping("/deleteImg/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable int id) throws Exception {
        studentService.deleteImgStudent(id);
        return ResponseEntity.ok().build();
    }

}
