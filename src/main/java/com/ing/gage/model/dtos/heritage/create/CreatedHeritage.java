package com.ing.gage.model.dtos.heritage.create;

import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.ing.gage.model.entities.heritage.Heritage}
 */
@Value
public class CreatedHeritage implements Serializable {
    OffsetDateTime created;
    Long id;
}