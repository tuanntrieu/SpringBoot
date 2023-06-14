package com.example.sendmail.services.imp;

import com.example.sendmail.dto.DataMailDTO;
import com.example.sendmail.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.nio.charset.StandardCharsets;

@Service
public class SentHtmlMail implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;
    @Override
    public void sendHtmlMail(DataMailDTO dataMailDTO, String templateName) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message, StandardCharsets.UTF_8.name());

        Context context = new Context();
        context.setVariables(dataMailDTO.getProps());

        String html = templateEngine.process(templateName, context);

        helper.setTo(dataMailDTO.getTo());
        helper.setSubject(dataMailDTO.getSubject());
        helper.setText(html, true);

        mailSender.send(message);
    }
}
