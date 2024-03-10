package com.ing.gage.model.dtos.asset.list;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.asset.Asset}
 */
@Value
public class AssetListRequest implements Serializable {
    DigitalUserDto digitalUser;
}