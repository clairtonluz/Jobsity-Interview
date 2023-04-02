package com.jobsity.jobsityinterview.infra.birthday.db;

import com.jobsity.jobsityinterview.app.birthdays.BirthdayPerson;
import com.jobsity.jobsityinterview.app.birthdays.driven.BirthdayDatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@ConditionalOnProperty(
        value = "app.birthdays.origin",
        havingValue = "sqlite"
)
public class BirthdaySqliteAdapter implements BirthdayDatabasePort {
    private final BirthdayPersonRepositry birthdayPersonRepositry;

    @Override
    public List<BirthdayPerson> findAll() {
        return birthdayPersonRepositry.findAll().stream()
                .map(BirthdayPersonEntity::toBirthdayPerson)
                .toList();
    }
}
