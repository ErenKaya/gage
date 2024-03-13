package com.ing.gage.model.service;

import com.ing.gage.model.dtos.transfer.create.CreateTransferRequest;
import com.ing.gage.model.dtos.transfer.create.CreateTransferResponse;
import com.ing.gage.model.dtos.transfer.get.GetTransferResponse;

import java.util.List;

public interface TransferService {

    CreateTransferResponse create(CreateTransferRequest request);

    List<GetTransferResponse> getTransferByTransferId(Long transferId);

}
