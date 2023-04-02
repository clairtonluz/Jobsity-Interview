package com.jobsity.jobsityinterview.infra.birthday.file;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(Throwable e) {
        super(e);
    }
}
