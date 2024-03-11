package com.ing.gage.model.dtos.transfer.get;

import com.ing.gage.model.enums.asset.AssetType;
import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
public class GetTransferAssetDto implements Serializable {
    OffsetDateTime created;
    OffsetDateTime updated;
    Long id;
    AssetType type;
    String name;
}