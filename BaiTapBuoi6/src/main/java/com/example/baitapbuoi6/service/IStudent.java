package com.example.baitapbuoi6.service;

import com.example.baitapbuoi6.dto.StudentDTO;
import com.example.baitapbuoi6.model.Student;

import java.util.List;

public interface IStudent {
    Student createStudent(StudentDTO studentDTO);
    Student updateStudentById(int id,StudentDTO studentDTO);
    void deleteStudentById(int id);
     List<Student> findAllStudent();
}
