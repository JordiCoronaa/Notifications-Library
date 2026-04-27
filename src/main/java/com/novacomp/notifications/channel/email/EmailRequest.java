package com.novacomp.notifications.channel.email;

import com.novacomp.notifications.api.NotificationRequest;

public class EmailRequest implements NotificationRequest {

    private final String recipient;
    private final String message;
    private final String subject;

    public EmailRequest(String recipient, String subject, String message) {
        this.recipient = recipient;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }
}