package com.ing.gage.model.enums.user;

import com.ing.gage.model.enums.notification.NotificationType;
import com.ing.gage.model.enums.transfer.TransferType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum MemberShipType {
    FREE(0), BASIC(1), GOLD(2), PRO(3);

    private final Integer value;

    private final static List<MemberShipType> valuesAsList = Arrays.asList(MemberShipType.values());

    MemberShipType(Integer value) {
        this.value = value;
    }

    public static MemberShipType forValue(Integer value) {
        return MemberShipType.valuesAsList.stream().filter(notificationType -> Objects.equals(notificationType.getValue(), value)).findAny().orElseThrow();
    }

    public Integer getValue() {

        return this.value;
    }
}
