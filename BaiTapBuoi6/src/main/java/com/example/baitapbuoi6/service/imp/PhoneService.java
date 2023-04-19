package com.example.baitapbuoi6.service.imp;

import com.example.baitapbuoi6.dto.PhoneDTO;
import com.example.baitapbuoi6.exception.NotFoundException;
import com.example.baitapbuoi6.model.Phone;
import com.example.baitapbuoi6.model.Student;
import com.example.baitapbuoi6.model.Subject;
import com.example.baitapbuoi6.repository.PhoneRepository;
import com.example.baitapbuoi6.repository.StudentRepository;
import com.example.baitapbuoi6.service.IPhone;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PhoneService implements IPhone {
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Phone createPhone(PhoneDTO phoneDTO) {
        Optional<Student> student = studentRepository.findById(phoneDTO.getStudent_id());
        if (student.isEmpty()) {
            throw new NotFoundException("Khong tim thay hoc sinh co id: " + phoneDTO.getStudent_id());
        }
        Phone phone = new Phone(phoneDTO.getName(), phoneDTO.getBrand(), student.get());
        phoneRepository.save(phone);
        return phone;
    }


    @Override
    public List<Phone> findAllPhone() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone updatePhoneById(int id, PhoneDTO phoneDTO) {
        Optional<Phone> phone = phoneRepository.findById(id);
        if (phone.isEmpty()) {
            throw new NotFoundException("Khong co dien thoai nao co id: " + id);
        }
        Optional<Student> student = studentRepository.findById(phoneDTO.getStudent_id());
        if (student.isEmpty()) {
            throw new NotFoundException("Khong tim thay hoc sinh co id: " + phoneDTO.getStudent_id());
        }
        phone.get().setName(phoneDTO.getName());
        phone.get().setBrand(phoneDTO.getBrand());
        phone.get().setStudent(student.get());
        phoneRepository.save(phone.get());
        return phone.get();
    }
}
