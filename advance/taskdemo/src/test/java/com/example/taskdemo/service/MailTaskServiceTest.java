package com.example.taskdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailTaskServiceTest {

    @Autowired
    private MailTaskService mailTaskService;
    @Test
    public void sendMail() {
        String toMail = "wxhcug@126.com";
        String subject = "Test";
        String message = "这事一封SpringBoot测试邮件";
        mailTaskService.sendSimpleMail(toMail,subject,message);
    }

    @Test
    public void sendComplexMail() throws MessagingException {
        mailTaskService.sendComplexMail();
    }
}