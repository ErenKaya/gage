package com.ing.gage.model.dtos.payment;

import com.ing.gage.model.entities.transfer.payment.Payment;
import com.ing.gage.model.enums.payment.PaymentType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

/**
 * DTO for {@link Payment}
 */
public record PaymentCompleteRequest(@NotNull(message = "Id must be filled") @Positive Long id,
                                     @NotNull PaymentType type) implements Serializable {
}