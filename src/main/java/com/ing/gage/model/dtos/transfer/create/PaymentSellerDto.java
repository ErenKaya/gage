package com.ing.gage.model.dtos.transfer.create;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.ing.gage.model.entities.transfer.payment.Payment}
 */
@Value
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class PaymentSellerDto implements Serializable {
    @NotNull(message = "Amount must be filled")
    BigDecimal amount;
}