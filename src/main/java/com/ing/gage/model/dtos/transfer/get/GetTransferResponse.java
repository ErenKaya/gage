package com.ing.gage.model.dtos.transfer.get;

import com.ing.gage.model.entities.transfer.Transfer;
import com.ing.gage.model.enums.transfer.TransferType;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Transfer}
 */
@Value
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class GetTransferResponse implements Serializable {
    GetTransferAssetDto asset;
    GetTransferPaymentDto payment;
    TransferType type;
}