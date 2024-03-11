package com.ing.gage.model.service;

import com.ing.gage.model.dtos.transfer.create.CreateTransferRequest;
import com.ing.gage.model.dtos.transfer.create.CreateTransferResponse;

public interface TransferService {

    CreateTransferResponse create(CreateTransferRequest request);

}
