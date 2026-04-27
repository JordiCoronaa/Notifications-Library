package com.novacomp.notifications;

import com.novacomp.notifications.api.NotificationResponse;
import com.novacomp.notifications.channel.email.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailNotificationSenderTest {

    @Test
    void shouldSendEmailSuccessfully() {
        EmailConfig config = new EmailConfig("key", "SendGrid");
        EmailNotificationSender sender = new EmailNotificationSender(config);

        EmailRequest request = new EmailRequest(
                "test@email.com",
                "Subject",
                "Message"
        );

        NotificationResponse response = sender.send(request);

        assertTrue(response.isSuccess());
        assertEquals("Email sent successfully", response.getMessage());
    }

    @Test
    void shouldFailWhenEmailIsInvalid() {
        EmailConfig config = new EmailConfig("key", "SendGrid");
        EmailNotificationSender sender = new EmailNotificationSender(config);

        EmailRequest request = new EmailRequest(
                "invalid-email",
                "Subject",
                "Message"
        );

        NotificationResponse response = sender.send(request);

        assertFalse(response.isSuccess());
        assertEquals("VALIDATION_ERROR", response.getErrorCode());
    }
}