package com.ing.gage.model.dtos.heritage;

import com.ing.gage.model.enums.asset.AssetType;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
public class HeritageAssetDTO implements Serializable {
    Long id;
    AssetType type;
    String name;
    String content;
    String description;
}