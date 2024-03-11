package com.ing.gage.model.dtos.transfer.create;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import com.ing.gage.model.entities.transfer.Transfer;
import com.ing.gage.model.enums.transfer.TransferType;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link Transfer}
 */
@Value
public class CreateTransferRequest implements Serializable {
    DigitalUserDto broker;
    CreateTransferAsset asset;
    PaymentSellerDto payment;
    @NotNull(message = "Transfer type must be filled")
    TransferType type;
    OffsetDateTime transferDate;
    String consumerMail;

}