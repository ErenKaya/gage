package com.ing.gage.repositories.transfer.payment;

import com.ing.gage.model.entities.transfer.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}