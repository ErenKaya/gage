package com.ing.gage.model.dtos.asset;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import com.ing.gage.model.dtos.heritage.OwnerUserDto;
import com.ing.gage.model.enums.asset.AssetType;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class CreatedAsset implements Serializable {
    OffsetDateTime created;
    OffsetDateTime updated;
    Long id;
    DigitalUserDto digitalUser;
    AssetType type;
    String name;
}