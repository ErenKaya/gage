package com.ing.gage.model.dtos.heritage.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
public class HeritageCreateAssetDto implements Serializable {
    @NotNull(message = "AssetId Must Be Filled")
    @NotBlank
    Long id;
}