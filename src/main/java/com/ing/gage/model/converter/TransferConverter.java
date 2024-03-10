package com.ing.gage.model.converter;

import com.ing.gage.model.enums.transfer.TransferType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransferConverter implements AttributeConverter<TransferType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TransferType transferType) {
        return transferType.getValue();
    }

    @Override
    public TransferType convertToEntityAttribute(Integer integer) {
        return TransferType.forValue(integer);
    }
}
