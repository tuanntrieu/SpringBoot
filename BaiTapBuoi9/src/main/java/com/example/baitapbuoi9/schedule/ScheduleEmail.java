package com.example.baitapbuoi9.schedule;

import com.example.baitapbuoi9.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class ScheduleEmail {
//    @Autowired
//    EmailService emailService;
//
//    @Scheduled(fixedRate = 10000)
//    void sentMailSchedule() throws MessagingException {
//        emailService.sentMail("trieudangtuann@gmail.com","Xin chao ae");
//    }
}
