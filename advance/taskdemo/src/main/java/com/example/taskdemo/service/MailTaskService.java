package com.example.taskdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailTaskService {

    @Autowired
    JavaMailSenderImpl mailSender;

    public void sendSimpleMail(String toMail,String subject,String message){
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("1848061514@qq.com");
        simpleMessage.setTo(toMail);
        simpleMessage.setSubject(subject);
        simpleMessage.setText(message);
        mailSender.send(simpleMessage);
    }

    public void sendComplexMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setTo("wxhcug@126.com");
        helper.setFrom("1848061514@qq.com");
        helper.setSubject("测试复杂邮件");
        helper.setText("<h1>下午开会</h1>",true);
        helper.addAttachment("激活说明.txt"
                ,new File("D:/激活说明.txt"));
        mailSender.send(mimeMessage);
    }
}
