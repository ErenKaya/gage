package com.ing.gage.model.dtos.heritage;

import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.ing.gage.model.entities.heritage.Heritage}
 */
@Value
public class HeritageDTO implements Serializable {
    OffsetDateTime created;
    OffsetDateTime updated;
    Long id;
    OwnerUserDto digitalOwner;
    CustudianUserDTO custodianDigitalUser;
    HeritageAssetDTO asset;
    String note;
}