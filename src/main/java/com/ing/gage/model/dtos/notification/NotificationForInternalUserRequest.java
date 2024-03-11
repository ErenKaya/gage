package com.ing.gage.model.dtos.notification;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import com.ing.gage.model.entities.notification.Notification;
import com.ing.gage.model.enums.notification.NotificationType;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Notification}
 */
public record NotificationForInternalUserRequest(DigitalUserDto digitalUser, String title, String content,
                                                 @NotNull NotificationType type) implements Serializable {
}