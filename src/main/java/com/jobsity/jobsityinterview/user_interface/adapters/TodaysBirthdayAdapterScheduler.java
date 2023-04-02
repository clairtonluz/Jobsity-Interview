package com.jobsity.jobsityinterview.user_interface.adapters;


import com.jobsity.jobsityinterview.app.birthdays.driving.BirthdayReminderPort;
import com.jobsity.jobsityinterview.app.birthdays.driving.HappyBirthdayPort;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TodaysBirthdayAdapterScheduler {

    private final HappyBirthdayPort happyBirthdayPort;
    private final BirthdayReminderPort birthdayReminderPort;

    @Scheduled(cron = "${app.birthdays.scheduler.congratulate}")
    public void happyBirthdays() {
        happyBirthdayPort.sendHappyBirthday();
    }

    @Scheduled(cron = "${app.birthdays.scheduler.reminders}")
    public void birthdayReminders() {
        birthdayReminderPort.sendReminderToSomeoneElseBirthday();
    }
}
