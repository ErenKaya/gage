package com.ing.gage.model.dtos.asset;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import com.ing.gage.model.dtos.heritage.OwnerUserDto;
import com.ing.gage.model.enums.asset.AssetType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
public class CreateAssetRequest implements Serializable {
    DigitalUserDto digitalUser;
    @NotNull(message = "AssetType must be filled")
    AssetType type;
    @NotNull(message = "Asset name must be filled")
    @NotEmpty(message = "Asset name must be filled")
    @NotBlank(message = "Asset name must be filled")
    String name;
    @NotNull(message = "Asset content must be filled")
    @NotEmpty(message = "Asset content must be filled")
    @NotBlank(message = "Asset content must be filled")
    String content;
    String description;
}
