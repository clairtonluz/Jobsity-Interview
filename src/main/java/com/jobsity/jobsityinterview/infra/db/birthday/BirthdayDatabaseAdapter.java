package com.jobsity.jobsityinterview.infra.db.birthday;

import com.jobsity.jobsityinterview.app.birthdays.BirthdayPerson;
import com.jobsity.jobsityinterview.app.birthdays.driven.BirthdayDatabasePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class BirthdayDatabaseAdapter implements BirthdayDatabasePort {
    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private final String databaseFile;

    public BirthdayDatabaseAdapter(@Value("${app.birthdays.db.path}") String databaseFile) {
        this.databaseFile = databaseFile;
    }

    @Override
    public List<BirthdayPerson> findAll() {
        try {
            return Files.readAllLines(Paths.get(databaseFile))
                    .stream()
                    .filter(line -> !line.startsWith("last_name"))
                    .map(line -> line.split(","))
                    .map(data -> BirthdayPerson.builder()
                            .lastName(data[0])
                            .firstName(data[1])
                            .dateOfBirth(LocalDate.parse(data[2], PATTERN))
                            .email(data[3])
                            .build())
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
