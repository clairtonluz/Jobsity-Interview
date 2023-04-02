package com.jobsity.jobsityinterview.infra.notification;

import com.jobsity.jobsityinterview.GenericMockitoTest;
import com.jobsity.jobsityinterview.app.notification.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

class EmailNotificationAdapterTest extends GenericMockitoTest {

    @Mock
    private JavaMailSender emailSender;
    private EmailNotificationAdapter emailNotificationAdapter;

    @BeforeEach
    @Override
    protected void setUp() {
        super.setUp();
        emailNotificationAdapter = new EmailNotificationAdapter(emailSender, "foobarteste@foobar.com");
    }

    @Test
    void send() {
        var to = "teste@foobar.com";
        Message message = new Message();
        message.setSubject("Subject Test");
        message.setBody("Body Test");
        emailNotificationAdapter.send(to, message);

        verify(emailSender, times(1))
                .send(any(SimpleMailMessage.class));
    }
}