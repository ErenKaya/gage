package com.ing.gage.model.dtos.heritage;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
public class OwnerUserDto implements Serializable {
    @NotNull
    @Positive
    Long id;
    String name;
}