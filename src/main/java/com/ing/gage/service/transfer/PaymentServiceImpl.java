package com.ing.gage.service.transfer;

import com.ing.gage.model.dtos.transfer.get.GetTransferPaymentDto;
import com.ing.gage.model.entities.transfer.payment.Payment;
import com.ing.gage.model.service.PaymentService;
import com.ing.gage.repositories.transfer.payment.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public GetTransferPaymentDto get(Long paymentId) {
        Payment payment = this.paymentRepository.findById(paymentId).orElseThrow();
        return new GetTransferPaymentDto(payment.getId(), payment.getAmount(), payment.getType());
    }
}
