package com.jobsity.jobsityinterview.infra.db.birthday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BirthdayDatabaseAdapterTest {

    private BirthdayDatabaseAdapter birthdayDatabasePort;

    @BeforeEach
    void setUp() {
        var path = Paths.get("src/test/resources/birthdays.txt").toAbsolutePath().toString();
        birthdayDatabasePort = new BirthdayDatabaseAdapter(path);
    }

    @Test
    void findAll() {
        var birthdayList = birthdayDatabasePort.findAll();
        assertNotNull(birthdayList);
        assertEquals(3, birthdayList.size());
        var fisrtBirthday = birthdayList.get(0);
        assertEquals("Doe", fisrtBirthday.getLastName());
        assertEquals("John", fisrtBirthday.getFirstName());
        assertEquals(LocalDate.of(1982, 10, 8), fisrtBirthday.getDateOfBirth());
        assertEquals("john.doe@foobar.com", fisrtBirthday.getEmail());
    }
}