package com.novacomp.notifications.channel.email;

import com.novacomp.notifications.api.NotificationResponse;
import com.novacomp.notifications.api.NotificationSender;
import com.novacomp.notifications.exception.ValidationException;
import com.novacomp.notifications.exception.NotificationException;
import com.novacomp.notifications.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotificationSender implements NotificationSender<EmailRequest> {

    private static final Logger log = LoggerFactory.getLogger(EmailNotificationSender.class);

    private final EmailConfig config;

    public EmailNotificationSender(EmailConfig config) {
        this.config = config;
    }

    @Override
    public NotificationResponse send(EmailRequest request) {

        try {
            validate(request);

            // Simulación de envío
            log.info("Sending EMAIL via {} to {} with subject '{}'",
                    config.getProvider(),
                    request.getRecipient(),
                    request.getSubject());

            return NotificationResponse.success("Email sent successfully");

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

    private void validate(EmailRequest request) {

        if (request.getRecipient() == null || !request.getRecipient().contains("@")) {
            throw new ValidationException("Invalid email address");
        }

        if (request.getSubject() == null || request.getSubject().isBlank()) {
            throw new ValidationException("Subject is required");
        }

        if (request.getMessage() == null || request.getMessage().isBlank()) {
            throw new ValidationException("Message is required");
        }
    }
}