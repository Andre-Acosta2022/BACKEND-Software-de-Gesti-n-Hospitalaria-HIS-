package com.clinic.Pagos_Service.service;
import com.clinic.Pagos_Service.domain.Payment;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    @Value("${stripe.secretKey}")
        //   private String secretKey;

    Payment create(Payment payment);
    Payment update(Payment payment);
    void delete(Long id);
    Optional<Payment> getById(Long id);
    List<Payment> getAll();


}