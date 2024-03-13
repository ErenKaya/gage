package com.ing.gage.model.service;

import com.ing.gage.model.dtos.payment.PaymentCompleteRequest;
import com.ing.gage.model.dtos.payment.PaymentCompleteResponse;
import com.ing.gage.model.dtos.transfer.get.GetTransferPaymentDto;

public interface PaymentService {

    GetTransferPaymentDto get(Long paymentId);


    PaymentCompleteResponse complete(PaymentCompleteRequest request);


}
