package com.ing.gage.model.enums.notification;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum NotificationType {
    WARNING(0), IMPORTANT(1), INFORMATION(2);

    private static List<NotificationType> values = Arrays.asList(NotificationType.values());
    private final Integer value;

    NotificationType(Integer i) {
        this.value = i;
    }

    public static NotificationType forValue(Integer value) {
        return NotificationType.values.stream().filter(notificationType -> Objects.equals(notificationType.getValue(), value)).findAny().orElse(NotificationType.WARNING);
    }


    public int getValue() {
        return value;
    }
}
