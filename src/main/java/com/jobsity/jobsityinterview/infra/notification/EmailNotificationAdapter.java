package com.jobsity.jobsityinterview.infra.notification;

import com.jobsity.jobsityinterview.app.notification.Message;
import com.jobsity.jobsityinterview.app.notification.driven.NotificationPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationAdapter implements NotificationPort {
    private final JavaMailSender emailSender;
    private final String from;

    public EmailNotificationAdapter(JavaMailSender emailSender, @Value("spring.mail.from") String from) {
        this.emailSender = emailSender;
        this.from = from;
    }

    @Override
    @Async
    public void send(String to, Message message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(message.getSubject());
        mailMessage.setText(message.getBody());
        emailSender.send(mailMessage);
    }
}
