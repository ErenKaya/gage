package com.ing.gage.model.dtos.asset;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import com.ing.gage.model.dtos.heritage.OwnerUserDto;
import com.ing.gage.model.enums.asset.AssetType;
import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
public class CreatedAsset implements Serializable {
    OffsetDateTime created;
    OffsetDateTime updated;
    Long id;
    DigitalUserDto digitalUser;
    AssetType type;
    String name;
}