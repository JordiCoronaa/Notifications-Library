package com.novacomp.notifications.factory;

import com.novacomp.notifications.api.NotificationRequest;
import com.novacomp.notifications.api.NotificationSender;

import java.util.HashMap;
import java.util.Map;

public class NotificationSenderFactory {

    private final Map<String, NotificationSender<?>> registry = new HashMap<>();

    public <T extends NotificationRequest> void register(String channel, NotificationSender<T> sender) {
        registry.put(channel.toLowerCase(), sender);
    }

    @SuppressWarnings("unchecked")
    public <T extends NotificationRequest> NotificationSender<T> getSender(String channel) {

        NotificationSender<?> sender = registry.get(channel.toLowerCase());

        if (sender == null) {
            throw new IllegalArgumentException("No sender registered for channel: " + channel);
        }

        return (NotificationSender<T>) sender;
    }
}