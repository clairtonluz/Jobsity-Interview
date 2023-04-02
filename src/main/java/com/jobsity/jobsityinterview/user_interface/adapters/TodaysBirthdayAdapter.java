package com.jobsity.jobsityinterview.user_interface.adapters;

import com.jobsity.jobsityinterview.app.birthdays.driving.BirthdayReminderPort;
import com.jobsity.jobsityinterview.app.birthdays.driving.HappyBirthdayPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/birthdays")
public class TodaysBirthdayAdapter {

    private final HappyBirthdayPort happyBirthdayPort;
    private final BirthdayReminderPort birthdayReminderPort;

    @PostMapping("congratulates")
    public void congratulates() {
        happyBirthdayPort.sendHappyBirthday();
    }

    @PostMapping("reminders")
    public void reminders() {
        birthdayReminderPort.sendReminderToSomeoneElseBirthday();
    }
}
