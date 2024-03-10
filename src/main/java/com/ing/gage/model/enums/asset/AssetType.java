package com.ing.gage.model.enums.asset;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum AssetType {
    DOC(0), PHOTO(1), VIDEO(2);

    private final Integer value;
    private static final List<AssetType> valuesAsList = Arrays.asList(AssetType.values());

    AssetType(Integer value) {
        this.value = value;
    }

    public static AssetType forValue(Integer value) {
        return AssetType.valuesAsList.stream().filter(notificationType -> Objects.equals(notificationType.getValue(), value)).findAny().orElse(AssetType.DOC);
    }


    public Integer getValue() {
        return value;
    }
}
