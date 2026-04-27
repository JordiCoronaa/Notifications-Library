package com.novacomp.notifications.api;

public class NotificationResponse {

    private final boolean success;
    private final String message;
    private final String errorCode;

    public NotificationResponse(boolean success, String message, String errorCode) {
        this.success = success;
        this.message = message;
        this.errorCode = errorCode;
    }

    public static NotificationResponse success(String message) {
        return new NotificationResponse(true, message, null);
    }

    public static NotificationResponse error(String message, String errorCode) {
        return new NotificationResponse(false, message, errorCode);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}