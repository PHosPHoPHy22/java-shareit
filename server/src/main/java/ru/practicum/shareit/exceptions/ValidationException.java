package ru.practicum.shareit.exceptions;


public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}