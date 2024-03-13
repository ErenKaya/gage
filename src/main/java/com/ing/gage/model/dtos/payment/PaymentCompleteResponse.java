package com.ing.gage.model.dtos.payment;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.transfer.payment.Payment}
 */
public record PaymentCompleteResponse(Long id, Boolean status) implements Serializable {
}