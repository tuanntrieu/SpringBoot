package com.example.baitapbuoi9.email;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;


public interface MailSender {

    void sentMailBirthday(String to,String message) throws MessagingException;

    void sentMailPassword(String to, String message) throws MessagingException;
}
