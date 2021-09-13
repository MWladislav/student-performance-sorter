package com.example.sorter.exceptions;

public class ParserException extends RuntimeException {


    public ParserException() {
        super();
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(Throwable cause) {
        super(cause);
    }
}
