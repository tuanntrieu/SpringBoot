package com.example.baitapbuoi6.service.imp;

import com.example.baitapbuoi6.dto.StudentDTO;
import com.example.baitapbuoi6.exception.NotFoundException;
import com.example.baitapbuoi6.model.Student;
import com.example.baitapbuoi6.repository.StudentRepository;
import com.example.baitapbuoi6.service.IStudent;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class StudentService implements IStudent {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Student student=new Student(studentDTO.getName(), studentDTO.getAddress());
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudentById(int id, StudentDTO studentDTO) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new NotFoundException("Khong tim thay hoc sinh co id: " + id);
        }
        student.get().setName(studentDTO.getName());
        student.get().setAddress(studentDTO.getAddress());
        studentRepository.save(student.get());
        return student.get();
    }

    @Override
    public void deleteStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new NotFoundException("Khong tim thay hoc sinh co id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
}
