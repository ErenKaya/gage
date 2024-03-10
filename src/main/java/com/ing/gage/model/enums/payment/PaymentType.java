package com.ing.gage.model.enums.payment;

import com.ing.gage.model.enums.asset.AssetType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum PaymentType {
    CREDIT_CARD(0), TRANSFER(1);

    private final Integer value;

    private static final List<PaymentType> valuesAsList = Arrays.asList(PaymentType.values());

    PaymentType(Integer value) {
        this.value = value;
    }

    public static PaymentType forValue(Integer value) {
        return PaymentType.valuesAsList.stream().filter(notificationType -> Objects.equals(notificationType.getValue(), value)).findAny().orElse(PaymentType.TRANSFER);
    }


    public Integer getValue() {

        return this.value;
    }
}
