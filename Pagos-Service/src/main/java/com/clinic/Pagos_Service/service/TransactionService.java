package com.clinic.Pagos_Service.service;

import com.clinic.Pagos_Service.domain.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction create(Transaction transaction);
    Transaction update(Transaction transaction);
    void delete(Long id);
    Optional<Transaction> getById(Long id);
    List<Transaction> getAll();
}