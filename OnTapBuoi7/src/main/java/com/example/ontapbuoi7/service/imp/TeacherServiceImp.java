package com.example.ontapbuoi7.service.imp;

import com.example.ontapbuoi7.dto.TeacherDTO;
import com.example.ontapbuoi7.exception.NotFoundException;
import com.example.ontapbuoi7.model.Student;
import com.example.ontapbuoi7.model.Teacher;
import com.example.ontapbuoi7.repo.StudenrRepository;
import com.example.ontapbuoi7.repo.TeacherRepository;
import com.example.ontapbuoi7.service.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TeacherServiceImp implements TeacherService {
    @Autowired
    StudenrRepository studenrRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Teacher createTeacher(TeacherDTO teacherDTO) {
        Optional<Student> student = studenrRepository.findById(teacherDTO.getStudent_id());
        if (student.isEmpty()) {
            throw new NotFoundException("Khong co hoc sinh nao co id " + teacherDTO.getStudent_id());
        }

        Teacher teacher = new Teacher(teacherDTO.getName(),teacherDTO.getPhoneNumber(),student.get());

        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty()) throw new NotFoundException("Khong co giao vien trong gs");
        return teachers;
    }

    @Override
    public void deleteTeacherById(int id) {

    }
}
