package com.jobsity.jobsityinterview.app.birthdays.driven;

import com.jobsity.jobsityinterview.app.birthdays.BirthdayPerson;

import java.util.List;

public interface BirthdayDatabasePort {
    List<BirthdayPerson> findAll();

}
