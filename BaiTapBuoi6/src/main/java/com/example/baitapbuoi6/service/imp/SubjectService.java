package com.example.baitapbuoi6.service.imp;

import com.example.baitapbuoi6.dto.SubjectDTO;
import com.example.baitapbuoi6.exception.NotFoundException;
import com.example.baitapbuoi6.model.Student;
import com.example.baitapbuoi6.model.Subject;
import com.example.baitapbuoi6.repository.StudentRepository;
import com.example.baitapbuoi6.repository.SubjectRepository;
import com.example.baitapbuoi6.service.ISubject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class SubjectService implements ISubject {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(SubjectDTO subjectDTO) {
        Optional<Student> student = studentRepository.findById(subjectDTO.getStudent_id());
        if (student.isEmpty()) {
            throw new NotFoundException("Khong tim thay hoc sinh co id: " + subjectDTO.getStudent_id());
        }
        Subject subject = new Subject(subjectDTO.getName(), student.get());
        subjectRepository.save(subject);
        return subject;
    }

    @Override
    public List<Subject> findAllSubject(int page, int size) {
        if (page < 0) {
            return subjectRepository.findAll();
        }
        return subjectRepository.findAll(PageRequest.of(page, size, Sort.by("name").descending())).getContent();
    }

    @Override
    public List<Subject> findAllSubjectByStudentId(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new NotFoundException("Khong tim thay hoc sinh co id: " + id);
        }
        List<Subject> subjects =student.get().getSubjects();
        if(subjects.isEmpty()){
            throw new NotFoundException("Khong co mon hoc nao");
        }
        return subjects;
    }
}
