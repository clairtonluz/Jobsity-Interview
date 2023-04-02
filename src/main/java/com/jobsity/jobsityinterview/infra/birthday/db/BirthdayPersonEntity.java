package com.jobsity.jobsityinterview.infra.birthday.db;

import com.jobsity.jobsityinterview.app.birthdays.BirthdayPerson;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BirthdayPersonEntity {
    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public BirthdayPerson toBirthdayPerson() {
        return BirthdayPerson.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(LocalDate.parse(dateOfBirth, PATTERN))
                .build();
    }
}
