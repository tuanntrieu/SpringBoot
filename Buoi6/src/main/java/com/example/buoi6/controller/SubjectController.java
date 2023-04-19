package com.example.buoi6.controller;

import com.example.buoi6.dto.StudentDTO;
import com.example.buoi6.dto.SubjectDTO;
import com.example.buoi6.model.Student;
import com.example.buoi6.model.Subject;
import com.example.buoi6.repository.StudentRepository;
import com.example.buoi6.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/create_new_subject")
    public ResponseEntity<?> createNewStudent(@RequestBody SubjectDTO subjectDTO) {
        Student student = studentRepository.findById(subjectDTO.getStudent_id())
                .orElseThrow(() -> {
                    System.out.println("Not found student with id: " + subjectDTO.getStudent_id());
                    return null;
                });

        Subject subject = new Subject(subjectDTO.getName(), student);
        return ResponseEntity.ok(subjectRepository.save(subject));
    }

    @GetMapping("/get_all_subject")
    public ResponseEntity<?> getAllSubject() {
        return ResponseEntity.ok(subjectRepository.findAll());
    }
}
