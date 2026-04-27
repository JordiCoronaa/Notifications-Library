package com.novacomp.notifications.exception;

public class NotificationException extends RuntimeException {

    private final ErrorCode errorCode;

    public NotificationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public NotificationException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}