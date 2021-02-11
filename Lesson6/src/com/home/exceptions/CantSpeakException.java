package com.home.exceptions;

public class CantSpeakException extends RuntimeException {
    public CantSpeakException() {
    }

    public CantSpeakException(String message) {
        super(message);
    }
}
