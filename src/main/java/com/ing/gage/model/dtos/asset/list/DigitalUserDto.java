package com.ing.gage.model.dtos.asset.list;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
public class DigitalUserDto implements Serializable {
    @NotNull(message = "UserId Must Be Filled")
    @Positive
    Long id;
}