package com.ing.gage.model.service;

import com.ing.gage.model.dtos.transfer.get.GetTransferPaymentDto;

public interface PaymentService {

    GetTransferPaymentDto get(Long paymentId);


}
