package com.lab.exception;

/**
 * Exception for NotFound actions.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public <T> NotFoundException(Class<T> classA) {
        super(String.format("Not found %s", classA.getSimpleName()));
    }
}
