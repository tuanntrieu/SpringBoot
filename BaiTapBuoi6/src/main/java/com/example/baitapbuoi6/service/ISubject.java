package com.example.baitapbuoi6.service;

import com.example.baitapbuoi6.dto.SubjectDTO;
import com.example.baitapbuoi6.model.Subject;

import java.util.List;

public interface ISubject {
    Subject createSubject(SubjectDTO subjectDTO);

    List<Subject> findAllSubject(int page,int size);

List<Subject>findAllSubjectByStudentId(int id);
}
