package com.novacomp.notifications.channel.sms;

import com.novacomp.notifications.api.NotificationRequest;

public class SmsRequest implements NotificationRequest {

    private final String recipient;
    private final String message;

    public SmsRequest(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public String getRecipient() {
        return recipient;
    }

    @Override
    public String getMessage() {
        return message;
    }
}