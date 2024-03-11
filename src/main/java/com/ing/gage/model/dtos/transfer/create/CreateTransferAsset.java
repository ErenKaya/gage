package com.ing.gage.model.dtos.transfer.create;

import com.ing.gage.model.entities.asset.Asset;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Asset}
 */
@Value
public class CreateTransferAsset implements Serializable {
    @NotNull
    Long id;
}