package com.ing.gage.model.enums.user;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum MembershipType {
    FREE(0), BASIC(1), GOLD(2), PRO(3);

    private final Integer value;

    private final static List<MembershipType> valuesAsList = Arrays.asList(MembershipType.values());

    MembershipType(Integer value) {
        this.value = value;
    }

    public static MembershipType forValue(Integer value) {
        return MembershipType.valuesAsList.stream().filter(notificationType -> Objects.equals(notificationType.getValue(), value)).findAny().orElseThrow();
    }

    public Integer getValue() {

        return this.value;
    }
}
