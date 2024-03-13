package com.ing.gage.model.dtos.heritage.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class CreatedHeritageCustodian implements Serializable {
    @NotNull(message = "Identity Must Be Filled")
    @NotBlank
    Long id;
}