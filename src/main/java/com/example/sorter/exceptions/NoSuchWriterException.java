package com.example.sorter.exceptions;

public class NoSuchWriterException extends RuntimeException{
    public NoSuchWriterException(String message) {
        super(message);
    }

    public NoSuchWriterException(String message, Throwable cause) {
        super(message, cause);
    }
}
