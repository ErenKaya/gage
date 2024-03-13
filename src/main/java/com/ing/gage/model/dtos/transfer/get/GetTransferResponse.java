package com.ing.gage.model.dtos.transfer.get;

import com.ing.gage.model.entities.transfer.Transfer;
import com.ing.gage.model.enums.transfer.TransferType;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Transfer}
 */
@Value
public class GetTransferResponse implements Serializable {
    GetTransferPaymentDto payment;
}