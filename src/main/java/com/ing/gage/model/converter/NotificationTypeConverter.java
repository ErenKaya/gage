package com.ing.gage.model.converter;

import com.ing.gage.model.enums.notification.NotificationType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NotificationTypeConverter implements AttributeConverter<NotificationType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(NotificationType notificationType) {
        return notificationType.getValue();
    }

    @Override
    public NotificationType convertToEntityAttribute(Integer integer) {
        return NotificationType.forValue(integer);
    }
}
