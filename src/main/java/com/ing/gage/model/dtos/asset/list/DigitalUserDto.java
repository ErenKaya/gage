package com.ing.gage.model.dtos.asset.list;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class DigitalUserDto implements Serializable {
    @NotNull(message = "UserId Must Be Filled")
    @Positive
    Long id;
}