package com.example.ontapbuoi7.repo;

import com.example.ontapbuoi7.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenrRepository extends JpaRepository<Student,Integer> {
}
