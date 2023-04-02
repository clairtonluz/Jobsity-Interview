package com.jobsity.jobsityinterview.app.birthdays.driving.impl;

import com.jobsity.jobsityinterview.GenericMockitoTest;
import com.jobsity.jobsityinterview.app.birthdays.BirthdayPerson;
import com.jobsity.jobsityinterview.app.birthdays.driven.BirthdayDatabasePort;
import com.jobsity.jobsityinterview.app.notification.driven.NotificationPort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;

class BirthdayReminderAdapterTest extends GenericMockitoTest {

    @Mock
    private BirthdayDatabasePort birthdayRepository;
    @Mock
    private NotificationPort notificationService;

    @InjectMocks
    private BirthdayReminderAdapter birthdayReminderAdapter;

    @Test
    void sendReminderToSomeoneElseBirthday() {
        var birthdayPerson = BirthdayPerson.builder()
                .email("person1@foobar.com")
                .lastName("Bar1")
                .firstName("Foo1")
                .dateOfBirth(LocalDate.now().minusYears(20))
                .build();

        var someoneElsePerson = BirthdayPerson.builder()
                .email("person2@foobar.com")
                .lastName("Bar2")
                .firstName("Foo2")
                .dateOfBirth(LocalDate.now().minusYears(10).plusDays(5))
                .build();

        when(birthdayRepository.findAll())
                .thenReturn(List.of(birthdayPerson, someoneElsePerson));

        birthdayReminderAdapter.sendReminderToSomeoneElseBirthday();

        verify(notificationService, times(1))
                .send(eq(someoneElsePerson.getEmail()), any());
        verify(notificationService, never())
                .send(eq(birthdayPerson.getEmail()), any());
    }
}