package com.ing.gage.model.service;

import com.ing.gage.model.dtos.transfer.create.CreateTransferRequest;
import com.ing.gage.model.dtos.transfer.create.CreateTransferResponse;
import com.ing.gage.model.dtos.transfer.get.GetTransferPaymentDto;
import com.ing.gage.model.dtos.transfer.get.GetTransferResponse;

public interface TransferService {

    CreateTransferResponse create(CreateTransferRequest request);

}
