package com.jobsity.jobsityinterview.infra.birthday.file;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayFileAdapterTest {

    private BirthdayFileAdapter birthdayDatabasePort;

    @Test
    void findAll() {
        var path = Paths.get("src/test/resources/birthdays.txt").toAbsolutePath().toString();
        birthdayDatabasePort = new BirthdayFileAdapter(path);

        var birthdayList = birthdayDatabasePort.findAll();
        assertNotNull(birthdayList);
        assertEquals(3, birthdayList.size());
        var fisrtBirthday = birthdayList.get(0);
        assertEquals("Doe", fisrtBirthday.getLastName());
        assertEquals("John", fisrtBirthday.getFirstName());
        assertEquals(LocalDate.of(1982, 10, 8), fisrtBirthday.getDateOfBirth());
        assertEquals("john.doe@foobar.com", fisrtBirthday.getEmail());
    }


    @Test
    void fileNotFound() {
        var path = Paths.get("src/test/resources/birthdays-fake.txt").toAbsolutePath().toString();
        birthdayDatabasePort = new BirthdayFileAdapter(path);
        assertThrows(RuntimeException.class, () -> birthdayDatabasePort.findAll());
    }
}