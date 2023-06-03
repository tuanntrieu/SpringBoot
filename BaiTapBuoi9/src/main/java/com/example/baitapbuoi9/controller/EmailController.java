package com.example.baitapbuoi9.controller;

import com.example.baitapbuoi9.email.EmailService;
import com.example.baitapbuoi9.email.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

//    @PostMapping("/sent")
//    public ResponseEntity<?> sentMail(@RequestParam String to,@RequestParam String email) throws MessagingException {
//        emailService.sentMail(to,email);
//        return ResponseEntity.ok("ok");
//
//    }
}
