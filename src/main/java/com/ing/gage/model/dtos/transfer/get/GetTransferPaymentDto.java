package com.ing.gage.model.dtos.transfer.get;

import com.ing.gage.model.enums.payment.PaymentType;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.ing.gage.model.entities.transfer.payment.Payment}
 */
@Value
public class GetTransferPaymentDto implements Serializable {
    Long id;
    BigDecimal amount;
    PaymentType type;
}