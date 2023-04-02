package com.jobsity.jobsityinterview.app.birthdays;

import lombok.*;

import java.time.LocalDate;
import java.time.Month;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BirthdayPerson {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;

    public boolean isBirthdayToday(LocalDate today) {
        if (dateOfBirth == null) return false;

        if (dateOfBirth.getMonth().equals(Month.FEBRUARY)
            && dateOfBirth.getDayOfMonth() == 29
            && !today.isLeapYear()
            && today.getMonth().equals(Month.FEBRUARY)
            && today.getDayOfMonth() == 28
        ) {
            return true;
        }

        return today.getDayOfMonth() == dateOfBirth.getDayOfMonth() &&
               today.getMonthValue() == dateOfBirth.getMonthValue();
    }

    public boolean hasEmail() {
        return email != null;
    }
}
