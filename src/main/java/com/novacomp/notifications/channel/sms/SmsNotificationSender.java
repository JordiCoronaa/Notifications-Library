package com.novacomp.notifications.channel.sms;

import com.novacomp.notifications.api.NotificationResponse;
import com.novacomp.notifications.api.NotificationSender;
import com.novacomp.notifications.exception.NotificationException;
import com.novacomp.notifications.exception.ValidationException;
import com.novacomp.notifications.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsNotificationSender implements NotificationSender<SmsRequest> {

    private static final Logger log = LoggerFactory.getLogger(SmsNotificationSender.class);

    private final SmsConfig config;

    public SmsNotificationSender(SmsConfig config) {
        this.config = config;
    }

    @Override
    public NotificationResponse send(SmsRequest request) {

        try {
            validate(request);

            // Simulación de envío
            log.info("Sending SMS via {} to {}",
                    config.getProvider(),
                    request.getRecipient());

            return NotificationResponse.success("SMS sent successfully");

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

    private void validate(SmsRequest request) {

        if (request.getRecipient() == null || request.getRecipient().isBlank()) {
            throw new ValidationException("Phone number is required");
        }

        if (request.getMessage() == null || request.getMessage().isBlank()) {
            throw new ValidationException("Message is required");
        }
    }
}