package com.clinic.Pagos_Service.service;

import com.clinic.Pagos_Service.domain.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    Invoice create(Invoice invoice);
    Invoice update(Invoice invoice);
    void delete(Long id);
    Optional<Invoice> getById(Long id);
    List<Invoice> getAll();
}