package com.ing.gage.model.dtos.heritage.get;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.heritage.Heritage}
 */
@Value
public class GetHeritageRequest implements Serializable {
    @NotNull
    Long id;
}