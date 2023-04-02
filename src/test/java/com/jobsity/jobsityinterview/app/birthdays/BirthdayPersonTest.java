package com.jobsity.jobsityinterview.app.birthdays;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BirthdayPersonTest {

    @Test
    void isBirthdayToday() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.now();
        birthdayPerson.setDateOfBirth(today.minusYears(10));
        assertTrue(birthdayPerson.isBirthdayToday(today));
    }

    @Test
    void isNotBirthdayToday() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.now();
        birthdayPerson.setDateOfBirth(today.minusDays(10));
        assertFalse(birthdayPerson.isBirthdayToday(today));
    }

    @Test
    void isNotBirthdayIn28FebruaryInLeapYear() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.of(2020, Month.FEBRUARY, 28);
        birthdayPerson.setDateOfBirth(LocalDate.of(2000, Month.FEBRUARY, 29));
        assertFalse(birthdayPerson.isBirthdayToday(today));
    }

    @Test
    void isBirthdayIn28FebruaryInNotLeapYear() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.of(2021, Month.FEBRUARY, 28);
        birthdayPerson.setDateOfBirth(LocalDate.of(2000, Month.FEBRUARY, 29));
        assertTrue(birthdayPerson.isBirthdayToday(today));
    }
    @Test
    void isBirthdayFalseWhenNull() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.now();
        assertFalse(birthdayPerson.isBirthdayToday(today));
    }

    @Test
    void isBirthdayIn28FebruaryInAnyYear() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.of(2021, Month.FEBRUARY, 28);
        birthdayPerson.setDateOfBirth(LocalDate.of(2001, Month.FEBRUARY, 28));
        assertTrue(birthdayPerson.isBirthdayToday(today));
    }


    @Test
    void BornIn29FebruaryAndIsNotLeapYearAndTodayIsNot28ButIsFebruary() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.of(2021, Month.FEBRUARY, 27);
        birthdayPerson.setDateOfBirth(LocalDate.of(2000, Month.FEBRUARY, 29));
        assertFalse(birthdayPerson.isBirthdayToday(today));
    }
    @Test
    void BornIn29FebruaryAndIsNotLeapYearAndTodayIs28ButNotIsFebruary() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.of(2021, Month.JANUARY, 28);
        birthdayPerson.setDateOfBirth(LocalDate.of(2000, Month.FEBRUARY, 29));
        assertFalse(birthdayPerson.isBirthdayToday(today));
    }


    @Test
    void BornInTheSameDayOfMonthButDifferentMonth() {
        var birthdayPerson = new BirthdayPerson();
        LocalDate today = LocalDate.of(2021, Month.JANUARY, 10);
        birthdayPerson.setDateOfBirth(LocalDate.of(2000, Month.FEBRUARY, 10));
        assertFalse(birthdayPerson.isBirthdayToday(today));
    }


    @Test
    void hasEmail() {
        var birthdayPerson = new BirthdayPerson();
        birthdayPerson.setEmail("foobar@foobar.com");
        assertTrue(birthdayPerson.hasEmail());
    }

    @Test
    void hasNotEmail() {
        var birthdayPerson = new BirthdayPerson();
        assertFalse(birthdayPerson.hasEmail());
    }
}