package com.novacomp.notifications.api;

public interface NotificationSender<T extends NotificationRequest> {

    NotificationResponse send(T request);

}