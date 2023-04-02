package com.jobsity.jobsityinterview.app.notification.driven;

import com.jobsity.jobsityinterview.app.notification.Message;

public interface NotificationPort {

    void send(String to, Message message);
}
