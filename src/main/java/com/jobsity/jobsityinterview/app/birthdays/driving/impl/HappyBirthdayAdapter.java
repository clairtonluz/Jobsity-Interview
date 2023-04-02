package com.jobsity.jobsityinterview.app.birthdays.driving.impl;

import com.jobsity.jobsityinterview.app.birthdays.BirthdayPerson;
import com.jobsity.jobsityinterview.app.birthdays.driven.BirthdayDatabasePort;
import com.jobsity.jobsityinterview.app.birthdays.driving.HappyBirthdayPort;
import com.jobsity.jobsityinterview.app.notification.Message;
import com.jobsity.jobsityinterview.app.notification.driven.NotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class HappyBirthdayAdapter implements HappyBirthdayPort {
    private final BirthdayDatabasePort birthdayRepository;
    private final NotificationPort notificationService;

    @Override
    public void sendHappyBirthday() {
        LocalDate today = LocalDate.now();
        birthdayRepository.findAll().stream()
                .filter(birthdayPerson -> birthdayPerson.isBirthdayToday(today))
                .filter(BirthdayPerson::hasEmail)
                .forEach(person -> {
                    var message = new Message();
                    message.setSubject("Happy birthday!");
                    message.setBody(String.format("Happy birthday, dear %s!", person.getFirstName()));
                    notificationService.send(person.getEmail(), message);
                });
    }
}
