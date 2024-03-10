package com.ing.gage.model.dtos.heritage.list;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.heritage.Heritage}
 */
@Value
public class HeritageListRequest implements Serializable {
    DigitalUserDto digitalOwner;
}