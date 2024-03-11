package com.ing.gage.model.dtos.transfer.create;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.ing.gage.model.entities.transfer.payment.Payment}
 */
@Value
public class PaymentSellerDto implements Serializable {
    @NotNull(message = "Amount must be filled")
    BigDecimal amount;
}