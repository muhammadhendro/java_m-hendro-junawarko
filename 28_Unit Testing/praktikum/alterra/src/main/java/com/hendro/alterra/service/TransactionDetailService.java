package com.hendro.alterra.service;

import com.hendro.alterra.domain.dto.TransactionDetailDto;
import org.springframework.http.ResponseEntity;

public interface TransactionDetailService {
    ResponseEntity<Object> getAllTransactionDetail();

    ResponseEntity<Object> saveTransactionDetail(TransactionDetailDto request);

    ResponseEntity<Object> deleteTransactionDetail(Long id);
}
