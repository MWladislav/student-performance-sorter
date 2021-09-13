package com.example.sorter.exceptions;

public class NoSuchParserException extends RuntimeException{
    public NoSuchParserException(String message) {
        super(message);
    }

    public NoSuchParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
