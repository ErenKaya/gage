package com.ing.gage.model.dtos.transfer.create;

import com.ing.gage.model.enums.asset.AssetType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
public class AssetDto implements Serializable {
    Long id;
    AssetType type;
    String name;
}