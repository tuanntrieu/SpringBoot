package com.example.baitapbuoi6.repository;

import com.example.baitapbuoi6.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {
}
