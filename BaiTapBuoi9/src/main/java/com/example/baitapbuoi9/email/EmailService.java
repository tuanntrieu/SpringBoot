package com.example.baitapbuoi9.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
@Service
public class EmailService implements MailSender {
    private final static Logger log= LoggerFactory.getLogger(MailSender.class);
    @Autowired
    JavaMailSender javaMailSender;
//    @Override
//    public void sentMail(String to, String email) throws MessagingException {
//        MimeMessage mailMessage=javaMailSender.createMimeMessage();
//        MimeMessageHelper messageHelper=new MimeMessageHelper(mailMessage,StandardCharsets.UTF_8.name());
//
//        messageHelper.setSubject("Hello");
//       // messageHelper.setFrom("trieudangtuan18032003@gmail.com");
//        messageHelper.setText(email,true);
//        messageHelper.setTo(to);
//        javaMailSender.send(mailMessage);
//    }
}
