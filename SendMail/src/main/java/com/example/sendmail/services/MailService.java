package com.example.sendmail.services;

import com.example.sendmail.dto.DataMailDTO;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
@Service
public interface MailService {

    void sendHtmlMail(DataMailDTO dataMailDTO,String tempalateName) throws MessagingException;
}
