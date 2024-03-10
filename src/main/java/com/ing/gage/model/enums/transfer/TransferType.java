package com.ing.gage.model.enums.transfer;

import com.ing.gage.model.enums.notification.NotificationType;
import com.ing.gage.model.enums.payment.PaymentType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum TransferType {
    FREE(0), PAID(1);

    private final Integer value;

    private static List<TransferType> valuesAsList = Arrays.asList(TransferType.values());

    TransferType(Integer value) {
        this.value = value;
    }

    public static TransferType forValue(Integer value) {
        return TransferType.valuesAsList.stream().filter(notificationType -> Objects.equals(notificationType.getValue(), value)).findAny().orElseThrow(NullPointerException::new);
    }

    public Integer getValue() {
        return this.value;
    }
}
