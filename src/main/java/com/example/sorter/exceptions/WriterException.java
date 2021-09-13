package com.example.sorter.exceptions;

public class WriterException extends RuntimeException {

    public WriterException(String message) {
        super(message);
    }

    public WriterException(String message, Throwable cause) {
        super(message, cause);
    }
}
