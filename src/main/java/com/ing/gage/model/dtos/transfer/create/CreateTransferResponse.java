package com.ing.gage.model.dtos.transfer.create;

import com.ing.gage.model.enums.transfer.TransferType;
import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.ing.gage.model.entities.transfer.Transfer}
 */
@Value
public class CreateTransferResponse implements Serializable {
    Long id;
    AssetDto asset;
    PaymentDto payment;
    TransferType type;
    OffsetDateTime transferDate;
}