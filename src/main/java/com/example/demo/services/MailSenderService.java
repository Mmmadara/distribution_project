package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    String subject = "Verification";

    String message = "To activate your account press the link\n\n"
            + "That link will expire in 2 hours\n\n"
            + "http://localhost:8083/api/auth/activate/";


    public void sendMail(String emailTo, String org, String activationCode) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText("From " + org + "\n" + message + activationCode);

        javaMailSender.send(mailMessage);
    }
}