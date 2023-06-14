package com.example.baitapbuoi9.schedule;

import com.example.baitapbuoi9.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class ScheduleEmail {
    @Autowired
    EmailService emailService;

    @Scheduled(cron = " 0 30 18  * * *")
    void sentMailSchedule() throws MessagingException {
        emailService.sentMailBirthday("trieudangtuan18032003@gmail.com", "Happy Birthday");
    }
}
