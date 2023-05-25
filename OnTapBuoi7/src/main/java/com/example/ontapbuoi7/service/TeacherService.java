package com.example.ontapbuoi7.service;

import com.example.ontapbuoi7.dto.TeacherDTO;
import com.example.ontapbuoi7.model.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher createTeacher(TeacherDTO teacherDTO);

    public List<Teacher> getAllTeacher();

    public void deleteTeacherById(int id);
}
