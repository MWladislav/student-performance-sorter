package com.example.sorter.exceptions;

public class NoSuchServiceException extends RuntimeException {
    public NoSuchServiceException(String message) {
        super(message);
    }
}
