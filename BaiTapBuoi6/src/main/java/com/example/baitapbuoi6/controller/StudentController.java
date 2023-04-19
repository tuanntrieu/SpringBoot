package com.example.baitapbuoi6.controller;

import com.example.baitapbuoi6.dto.StudentDTO;
import com.example.baitapbuoi6.service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class StudentController {

    @Autowired
    IStudent studentService;

    @PostMapping("/create_student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentDTO));
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("successful delete");
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.updateStudentById(id, studentDTO));
    }

    @GetMapping("/viewAllStudent")
    public ResponseEntity<?> viewAllStudent() {
        return ResponseEntity.ok().body(studentService.findAllStudent());
    }

}
