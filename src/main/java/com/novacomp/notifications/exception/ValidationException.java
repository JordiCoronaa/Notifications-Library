package com.novacomp.notifications.exception;

public class ValidationException extends NotificationException {

    public ValidationException(String message) {
        super(message, ErrorCode.VALIDATION_ERROR);
    }
}