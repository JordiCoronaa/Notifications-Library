package com.novacomp.notifications.examples;

import com.novacomp.notifications.api.*;
import com.novacomp.notifications.channel.email.*;
import com.novacomp.notifications.factory.NotificationSenderFactory;

public class NotificationExample {

    public static void main(String[] args) {

        NotificationSenderFactory factory = new NotificationSenderFactory();

        factory.register("email",
                new EmailNotificationSender(
                        new EmailConfig("API_KEY", "SendGrid")
                )
        );

        NotificationSender<EmailRequest> sender = factory.getSender("email");

        EmailRequest request = new EmailRequest(
                "test@email.com",
                "Hello",
                "Docker test message"
        );

        NotificationResponse response = sender.send(request);

        System.out.println("Success: " + response.isSuccess());
        System.out.println("Message: " + response.getMessage());
    }
}