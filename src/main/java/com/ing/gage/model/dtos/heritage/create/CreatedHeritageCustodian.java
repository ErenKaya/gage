package com.ing.gage.model.dtos.heritage.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
public class CreatedHeritageCustodian implements Serializable {
    @NotNull(message = "Identity Must Be Filled")
    @NotBlank
    Long identity;
}