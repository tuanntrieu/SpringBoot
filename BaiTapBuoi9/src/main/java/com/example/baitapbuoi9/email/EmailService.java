package com.example.baitapbuoi9.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;

@Service
public class EmailService implements MailSender {
    //private final static Logger log = LoggerFactory.getLogger(MailSender.class);
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;


    @Override
    public void sentMailBirthday(String to, String message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
        String html = springTemplateEngine.process("birthday.html", new Context());
        helper.setTo(to);
        helper.setText(html, true);
        helper.setSubject(message);//tiêu đề
        helper.setFrom("tuanntrieu18@gmail.com");
        javaMailSender.send(mimeMessage);
    }

    @Override
    public void sentMailPassword(String to, String message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
        helper.setTo(to);
        helper.setSubject("Mật khẩu");//tiêu đề
        helper.setFrom("tuanntrieu18@gmail.com");
        helper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }
}
