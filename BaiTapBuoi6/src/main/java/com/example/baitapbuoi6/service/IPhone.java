package com.example.baitapbuoi6.service;

import com.example.baitapbuoi6.dto.PhoneDTO;
import com.example.baitapbuoi6.model.Phone;

import java.util.List;

public interface IPhone {
    Phone createPhone(PhoneDTO phoneDTO);

    List<Phone> findAllPhone();

    Phone updatePhoneById(int id, PhoneDTO phoneDTO);
}
