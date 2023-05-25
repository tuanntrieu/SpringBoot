package com.example.ontapbuoi7.service;

import com.example.ontapbuoi7.dto.StudentDTO;
import com.example.ontapbuoi7.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    public Student create(StudentDTO studentDTO) throws IOException, Exception;
    public Student create2(StudentDTO studentDTO) throws IOException;
    public void deleteImgStudent(int id) throws Exception;
    public List<Student> getAllStudent();
    public void deleteStudent(int id);
}
