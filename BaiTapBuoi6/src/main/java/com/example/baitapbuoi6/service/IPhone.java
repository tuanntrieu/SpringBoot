package com.example.baitapbuoi6.service;

import com.example.baitapbuoi6.dto.PhoneDTO;
import com.example.baitapbuoi6.model.Phone;

public interface IPhone {
    Phone createPhone(PhoneDTO phoneDTO);
}
