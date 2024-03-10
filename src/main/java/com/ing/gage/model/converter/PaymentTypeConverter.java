package com.ing.gage.model.converter;

import com.ing.gage.model.enums.notification.NotificationType;
import com.ing.gage.model.enums.payment.PaymentType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentTypeConverter implements AttributeConverter<PaymentType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PaymentType paymentType) {
        return paymentType.getValue();
    }

    @Override
    public PaymentType convertToEntityAttribute(Integer integer) {
        return PaymentType.forValue(integer);
    }
}
