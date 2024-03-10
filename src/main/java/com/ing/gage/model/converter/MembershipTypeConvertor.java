package com.ing.gage.model.converter;

import com.ing.gage.model.enums.transfer.TransferType;
import com.ing.gage.model.enums.user.MemberShipType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MembershipTypeConvertor implements AttributeConverter<MemberShipType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(MemberShipType memberShipType) {
        return memberShipType.getValue();
    }

    @Override
    public MemberShipType convertToEntityAttribute(Integer integer) {
        return MemberShipType.forValue(integer);
    }
}
