package com.novacomp.notifications;

import com.novacomp.notifications.api.NotificationResponse;
import com.novacomp.notifications.channel.sms.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmsNotificationSenderTest {

    @Test
    void shouldSendSmsSuccessfully() {
        SmsConfig config = new SmsConfig("key", "Twilio");
        SmsNotificationSender sender = new SmsNotificationSender(config);

        SmsRequest request = new SmsRequest(
                "+521234567890",
                "Hello SMS"
        );

        NotificationResponse response = sender.send(request);

        assertTrue(response.isSuccess());
    }

    @Test
    void shouldFailWhenPhoneIsEmpty() {
        SmsConfig config = new SmsConfig("key", "Twilio");
        SmsNotificationSender sender = new SmsNotificationSender(config);

        SmsRequest request = new SmsRequest(
                "",
                "Hello SMS"
        );

        NotificationResponse response = sender.send(request);

        assertFalse(response.isSuccess());
        assertEquals("VALIDATION_ERROR", response.getErrorCode());
    }
}