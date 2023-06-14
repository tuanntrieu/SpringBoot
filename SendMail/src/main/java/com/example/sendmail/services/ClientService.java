package com.example.sendmail.services;

import com.example.sendmail.dto.sdi.ClientSdi;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    Boolean create(ClientSdi sdi);
}
