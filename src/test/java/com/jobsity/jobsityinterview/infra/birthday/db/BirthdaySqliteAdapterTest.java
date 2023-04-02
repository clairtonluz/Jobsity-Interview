package com.jobsity.jobsityinterview.infra.birthday.db;

import com.jobsity.jobsityinterview.GenericMockitoTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class BirthdaySqliteAdapterTest extends GenericMockitoTest {
    @Mock
    private BirthdayPersonRepositry birthdayPersonRepositry;
    @InjectMocks
    private BirthdaySqliteAdapter birthdaySqliteAdapter;

    @Test
    void findAll() {
        var p1 = BirthdayPersonEntity.builder()
                .email("person1@foobar.com")
                .lastName("Bar1")
                .firstName("Foo1")
                .dateOfBirth("2000/02/22")
                .build();

        when(birthdayPersonRepositry.findAll())
                .thenReturn(List.of(p1));

        var result = birthdaySqliteAdapter.findAll();

        assertNotNull(result);
        var person = result.get(0);
        assertEquals(p1.getFirstName(), person.getFirstName());
        assertEquals(p1.getLastName(), person.getLastName());
        assertEquals(p1.getEmail(), person.getEmail());
        assertEquals(p1.getDateOfBirth(), person.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    }
}