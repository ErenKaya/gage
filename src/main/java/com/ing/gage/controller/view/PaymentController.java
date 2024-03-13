package com.ing.gage.controller.view;

import com.ing.gage.model.dtos.transfer.get.GetTransferPaymentDto;
import com.ing.gage.model.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @GetMapping(path = "get/v1")
    public GetTransferPaymentDto get(@RequestBody @RequestParam(value = "paymentId") Long paymentId) {
        return paymentService.get(paymentId);
    }


}
