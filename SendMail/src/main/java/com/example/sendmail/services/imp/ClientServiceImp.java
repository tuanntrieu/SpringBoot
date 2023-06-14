package com.example.sendmail.services.imp;

import com.example.sendmail.dto.DataMailDTO;
import com.example.sendmail.dto.sdi.ClientSdi;
import com.example.sendmail.services.ClientService;
import com.example.sendmail.services.MailService;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private MailService mailService;
    @Override
    public Boolean create(ClientSdi sdi) {
        try {
            DataMailDTO dataMail = new DataMailDTO();

            dataMail.setTo(sdi.getEmail());
            dataMail.setSubject("Xác nhận tạo tt khách hàng");

            Map<String, Object> props = new HashMap<>();
            props.put("name", sdi.getName());
            props.put("username", sdi.getUsername());
            props.put("password", 123);
            dataMail.setProps(props);

            mailService.sendHtmlMail(dataMail, "client");
            return true;
        } catch (MessagingException exp){
            exp.printStackTrace();
        }
        return false;
    }

}
