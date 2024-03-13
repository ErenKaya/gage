package com.ing.gage.model.dtos.transfer.get;

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
public class GetTransferAssetDto implements Serializable {
    OffsetDateTime created;
    OffsetDateTime updated;
    Long id;
    AssetType type;
    String name;

}