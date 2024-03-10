package com.ing.gage.model.dtos.heritage.create;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.heritage.Heritage}
 */
@Value
public class CreateHeritageRequest implements Serializable {
    Long id;
    DigitalUserDto digitalOwner;
    CreatedHeritageCustodian custodianDigitalUser;
    HeritageCreateAssetDto asset;
    String note;
}