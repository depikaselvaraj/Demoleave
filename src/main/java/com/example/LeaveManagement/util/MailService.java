package com.example.LeaveManagement.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {

    String mailfrom;

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String from,String to,String subject){

        String message="hii hello welcome to the attendendance portal";

        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(message);
        javaMailSender.send(msg);

    }
}
