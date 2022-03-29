package com.hendro.alterra.service;

import com.hendro.alterra.domain.dto.TransactionDto;
import org.springframework.http.ResponseEntity;

public interface TransactionService {
    ResponseEntity<Object> getAllTransaction();

    ResponseEntity<Object> getTransactionById(Long id);

    ResponseEntity<Object> saveTransaction(TransactionDto request);

    ResponseEntity<Object> deleteTransaction(Long id);
}
