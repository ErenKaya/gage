package com.ing.gage.model.dtos.transfer.create;

import com.ing.gage.model.entities.asset.Asset;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Asset}
 */
@Value
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class CreateTransferAsset implements Serializable {
    @NotNull
    Long id;
}