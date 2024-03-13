package com.ing.gage.model.dtos.heritage.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class HeritageCreateAssetDto implements Serializable {
    @NotNull(message = "AssetId Must Be Filled")
    @NotBlank
    Long id;
}