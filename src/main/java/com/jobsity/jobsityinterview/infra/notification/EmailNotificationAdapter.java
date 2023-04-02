package com.jobsity.jobsityinterview.infra.notification;

import com.jobsity.jobsityinterview.app.notification.Message;
import com.jobsity.jobsityinterview.app.notification.driven.NotificationPort;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationAdapter implements NotificationPort {
    @Override
    public void send(String to, Message message) {
        System.out.printf("to: %s\n", to);
        System.out.printf("Subject: %s\n", message.getSubject());
        System.out.printf("Body: %s\n", message.getBody());
    }
}
