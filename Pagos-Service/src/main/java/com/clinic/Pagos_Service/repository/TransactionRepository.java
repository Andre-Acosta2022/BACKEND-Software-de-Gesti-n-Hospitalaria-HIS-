package com.clinic.Pagos_Service.repository;

import com.clinic.Pagos_Service.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}