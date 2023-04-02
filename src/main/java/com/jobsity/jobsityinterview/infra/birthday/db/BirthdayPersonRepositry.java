package com.jobsity.jobsityinterview.infra.birthday.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayPersonRepositry extends JpaRepository<BirthdayPersonEntity, Long> {
}
