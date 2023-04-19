package com.example.baitapbuoi6.controller;

import com.example.baitapbuoi6.dto.SubjectDTO;
import com.example.baitapbuoi6.service.ISubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class SubjectController {
    @Autowired
    ISubject subjectServiece;

    @PostMapping("/create_subject")
    public ResponseEntity<?> creatNewSubject(@RequestBody SubjectDTO subjectDTO) {

        return ResponseEntity.ok(subjectServiece.createSubject(subjectDTO));
    }

    @GetMapping("/getSubjectByStudentId/{id}")
    public ResponseEntity<?> getSubjectByStudentId(@PathVariable int id) {
        return ResponseEntity.ok(subjectServiece.findAllSubjectByStudentId(id));
    }

    @GetMapping("/viewAllSubject")
    public ResponseEntity<?> getAllSubject(@RequestParam(name = "page", required = false) int page,
                                           @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        return ResponseEntity.ok(subjectServiece.findAllSubject(page, size));
    }

}
