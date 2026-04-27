package com.novacomp.notifications.channel.push;

import com.novacomp.notifications.api.NotificationRequest;

public class PushRequest implements NotificationRequest {

    private final String recipient; // deviceToken
    private final String title;
    private final String message;

    public PushRequest(String recipient, String title, String message) {
        this.recipient = recipient;
        this.title = title;
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

    public String getTitle() {
        return title;
    }
}