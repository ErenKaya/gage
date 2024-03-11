package com.ing.gage.model.entities.notification;

import com.ing.gage.model.enums.notification.NotificationType;

import java.io.Serializable;

/**
 * DTO for {@link Notification}
 */
public record NotificationForExternalRequest(String title, String content,
                                             NotificationType type) implements Serializable {
}