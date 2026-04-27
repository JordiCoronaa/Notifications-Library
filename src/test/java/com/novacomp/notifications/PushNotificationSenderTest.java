package com.novacomp.notifications;

import com.novacomp.notifications.api.NotificationResponse;
import com.novacomp.notifications.channel.push.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PushNotificationSenderTest {

    @Test
    void shouldSendPushSuccessfully() {
        PushConfig config = new PushConfig("key", "Firebase");
        PushNotificationSender sender = new PushNotificationSender(config);

        PushRequest request = new PushRequest(
                "device-token",
                "Title",
                "Message"
        );

        NotificationResponse response = sender.send(request);

        assertTrue(response.isSuccess());
    }

    @Test
    void shouldFailWhenTitleIsMissing() {
        PushConfig config = new PushConfig("key", "Firebase");
        PushNotificationSender sender = new PushNotificationSender(config);

        PushRequest request = new PushRequest(
                "device-token",
                "",
                "Message"
        );

        NotificationResponse response = sender.send(request);

        assertFalse(response.isSuccess());
        assertEquals("VALIDATION_ERROR", response.getErrorCode());
    }
}