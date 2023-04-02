package com.jobsity.jobsityinterview.infra.db.birthday;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayDatabaseAdapterTest {

    private BirthdayDatabaseAdapter birthdayDatabasePort;

    @Test
    void findAll() {
        var path = Paths.get("src/test/resources/birthdays.txt").toAbsolutePath().toString();
        birthdayDatabasePort = new BirthdayDatabaseAdapter(path);

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
        birthdayDatabasePort = new BirthdayDatabaseAdapter(path);
        assertThrows(RuntimeException.class, () -> birthdayDatabasePort.findAll());
    }
}