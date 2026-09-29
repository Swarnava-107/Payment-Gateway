package org.dev.paymentgateway.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String toEmail, String name, String course, Double amount) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Payment Successful for "+ course);
        message.setText("Hi "+ name+ ", \n \n " +
                "Thank you for enrolling in "+ course + ".\n\n"+
                "Looking forward to see you in live class");
        mailSender.send(message);
    }
}
