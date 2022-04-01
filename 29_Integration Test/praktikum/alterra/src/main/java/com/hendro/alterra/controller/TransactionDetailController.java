package com.hendro.alterra.controller;

import com.hendro.alterra.domain.dto.TransactionDetailDto;
import com.hendro.alterra.domain.dto.TransactionDto;
import com.hendro.alterra.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/transaction_detail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionDetailController {

    @Autowired
    private TransactionDetailService transactionDetailService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return transactionDetailService.getAllTransactionDetail();
    }


    @PostMapping(value = "")
    public ResponseEntity<Object> save(@RequestBody TransactionDetailDto request) {
        return transactionDetailService.saveTransactionDetail(request);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return transactionDetailService.deleteTransactionDetail(id);
    }
}
