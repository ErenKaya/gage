package com.ing.gage.model.converter;

import com.ing.gage.model.enums.user.MembershipType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MembershipTypeConvertor implements AttributeConverter<MembershipType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(MembershipType memberShipType) {
        return memberShipType.getValue();
    }

    @Override
    public MembershipType convertToEntityAttribute(Integer integer) {
        return MembershipType.forValue(integer);
    }
}
