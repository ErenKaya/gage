package com.ing.gage.model.converter;

import com.ing.gage.model.enums.asset.AssetType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AssetTypeConverter implements AttributeConverter<AssetType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AssetType assetType) {
        return assetType.getValue();
    }

    @Override
    public AssetType convertToEntityAttribute(Integer integer) {
        return AssetType.forValue(integer);
    }
}
