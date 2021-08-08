package com.example.inst.model.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(Throwable throwable) {
        super(throwable);
    }
}
