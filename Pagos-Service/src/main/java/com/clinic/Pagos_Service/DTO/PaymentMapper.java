package com.clinic.Pagos_Service.DTO;

import com.clinic.Pagos_Service.domain.Payment;

public class PaymentMapper {
    public static PaymentDTO toDto(Payment payment) {
        if (payment == null) return null;

        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setMonto(payment.getMonto());
        dto.setEstado(payment.getEstado());
        dto.setFecha(payment.getFecha());
        dto.setErrorMessage(payment.getErrorMessage());

        if (payment.getMethod() != null) {
            dto.setMethodName(payment.getMethod().getMetodoDePago());
        }

        if (payment.getInvoice() != null) {
            dto.setInvoiceId(payment.getInvoice().getId());
        }

        return dto;
    }
}