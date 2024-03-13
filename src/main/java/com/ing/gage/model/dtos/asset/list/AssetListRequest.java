package com.ing.gage.model.dtos.asset.list;

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
public class AssetListRequest implements Serializable {
    DigitalUserDto digitalUser;
}