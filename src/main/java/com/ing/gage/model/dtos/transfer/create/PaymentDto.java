package com.ing.gage.model.dtos.transfer.create;

import com.ing.gage.model.enums.payment.PaymentType;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.ing.gage.model.entities.transfer.payment.Payment}
 */
@Value
public class PaymentDto implements Serializable {
    Long id;
    BigDecimal amount;
    PaymentType type;
    Boolean status;
}