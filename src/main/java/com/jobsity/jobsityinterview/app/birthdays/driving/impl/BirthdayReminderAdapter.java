package com.jobsity.jobsityinterview.app.birthdays.driving.impl;

import com.jobsity.jobsityinterview.app.birthdays.BirthdayPerson;
import com.jobsity.jobsityinterview.app.birthdays.driven.BirthdayDatabasePort;
import com.jobsity.jobsityinterview.app.birthdays.driving.BirthdayReminderPort;
import com.jobsity.jobsityinterview.app.notification.Message;
import com.jobsity.jobsityinterview.app.notification.driven.NotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class BirthdayReminderAdapter implements BirthdayReminderPort {
    private final BirthdayDatabasePort birthdayRepository;
    private final NotificationPort notificationService;

    private String createReminderMessage(BirthdayPerson personToRemember, BirthdayPerson birthdayPerson) {
        return String.format("""
                        Dear %s,
                        Today is %s %s's birthday.
                        Don't forget to send him a message !""",
                personToRemember.getFirstName(), birthdayPerson.getFirstName(), birthdayPerson.getLastName());
    }

    @Override
    public void sendReminderToSomeoneElseBirthday() {
        var birthdayPersonList = birthdayRepository.findAll();
        LocalDate today = LocalDate.now();
        var todaysBirthdays = birthdayPersonList.stream()
                .filter(birthdayPerson -> birthdayPerson.isBirthdayToday(today))
                .toList();

        if (!todaysBirthdays.isEmpty()) {
            todaysBirthdays.forEach(birthdayPerson -> {
                birthdayPersonList.stream()
                        .filter(BirthdayPerson::hasEmail)
                        .filter(personToRemember -> !personToRemember.getEmail().equals(birthdayPerson.getEmail()))
                        .forEach(personToRemember -> {
                            var message = new Message();
                            message.setSubject("Birthday Reminder");
                            message.setBody(createReminderMessage(personToRemember, birthdayPerson));
                            notificationService.send(personToRemember.getEmail(), message);
                        });

            });
        }
    }
}
