package com.example.baitapbuoi6.controller;

import com.example.baitapbuoi6.dto.SubjectDTO;
import com.example.baitapbuoi6.model.Student;
import com.example.baitapbuoi6.model.Subject;
import com.example.baitapbuoi6.repository.StudentRepository;
import com.example.baitapbuoi6.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create_subject")
    public ResponseEntity<?> creatNewSubject(@RequestBody SubjectDTO subjectDTO) {
        Student student = studentRepository.findById(subjectDTO.getStudent_id()).orElseThrow(() -> {
            throw new RuntimeException("Not found student with id: " + subjectDTO.getStudent_id());
        });
        Subject subject = new Subject(subjectDTO.getName(), student);
        return ResponseEntity.ok(subjectRepository.save(subject));
    }


    @GetMapping("/viewAllSubject")
    public ResponseEntity<?> getAllSubject() {
        return ResponseEntity.ok(subjectRepository.findAll());
    }

}
