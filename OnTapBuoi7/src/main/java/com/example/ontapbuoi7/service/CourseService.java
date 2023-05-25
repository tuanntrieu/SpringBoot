package com.example.ontapbuoi7.service;

import com.example.ontapbuoi7.dto.CourseDTO;
import com.example.ontapbuoi7.model.Course;

import java.util.List;

public interface CourseService {
    public Course createCourse(CourseDTO courseDTO);

    public List<Course> getAllCourse();

    public void deleteCourseById(int id);
}
