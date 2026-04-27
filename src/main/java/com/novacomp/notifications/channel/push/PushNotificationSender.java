package com.novacomp.notifications.channel.push;

import com.novacomp.notifications.api.NotificationResponse;
import com.novacomp.notifications.api.NotificationSender;
import com.novacomp.notifications.exception.NotificationException;
import com.novacomp.notifications.exception.ValidationException;
import com.novacomp.notifications.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PushNotificationSender implements NotificationSender<PushRequest> {

    private static final Logger log = LoggerFactory.getLogger(PushNotificationSender.class);

    private final PushConfig config;

    public PushNotificationSender(PushConfig config) {
        this.config = config;
    }

    @Override
    public NotificationResponse send(PushRequest request) {

        try {
            validate(request);

            // Simulación de envío
            log.info("Sending PUSH via {} to {} with title '{}'",
                    config.getProvider(),
                    request.getRecipient(),
                    request.getTitle());

            return NotificationResponse.success("Push notification sent successfully");

        } catch (NotificationException e) {
            return NotificationResponse.error(
                    e.getMessage(),
                    e.getErrorCode().name()
            );

        } catch (Exception e) {
            return NotificationResponse.error(
                    "Unexpected error",
                    ErrorCode.UNKNOWN_ERROR.name()
            );
        }
    }

    private void validate(PushRequest request) {

        if (request.getRecipient() == null || request.getRecipient().isBlank()) {
            throw new ValidationException("Device token is required");
        }

        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new ValidationException("Title is required");
        }

        if (request.getMessage() == null || request.getMessage().isBlank()) {
            throw new ValidationException("Message is required");
        }
    }
}