package com.example.ontapbuoi7.controller;

import com.example.ontapbuoi7.dto.TeacherDTO;
import com.example.ontapbuoi7.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @PostMapping("/createTeacher")
    public ResponseEntity<?> createTeacher(@RequestBody TeacherDTO teacherDTO){
        return ResponseEntity.ok(teacherService.createTeacher(teacherDTO));
    }

    @GetMapping("/findAllTeacher")
    public ResponseEntity<?> findAllTeacher(){
        return ResponseEntity.ok(teacherService.getAllTeacher());
    }
}
