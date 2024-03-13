package com.ing.gage.model.dtos.heritage.create;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.heritage.Heritage}
 */

@Value
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class CreateHeritageRequest implements Serializable {
    DigitalUserDto digitalOwner;
    CreatedHeritageCustodian custodianDigitalUser;
    HeritageCreateAssetDto asset;
    String note;
}