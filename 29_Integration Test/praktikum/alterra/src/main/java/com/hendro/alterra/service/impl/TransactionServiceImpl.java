package com.hendro.alterra.service.impl;

import com.hendro.alterra.constant.AppConstant;
import com.hendro.alterra.domain.dao.TransactionDao;
import com.hendro.alterra.domain.dto.TransactionDto;
import com.hendro.alterra.repository.TransactionRepository;
import com.hendro.alterra.service.TransactionService;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public ResponseEntity<Object> getAllTransaction() {
        List<TransactionDao> daoList = transactionRepository.findAll();
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", daoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getTransactionById(Long id) {
        Optional<TransactionDao> transactionDaoOptional = transactionRepository.findById(id);
        if(transactionDaoOptional.isEmpty()){
            return ResponseUtil.build( AppConstant.ResponseCode.NOT_FOUND, "DATA_NOT_FOUND",null, HttpStatus.BAD_REQUEST);
        }
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS", transactionDaoOptional.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> saveTransaction(TransactionDto request) {
        TransactionDao transactionDao = TransactionDao.builder()
                .id(request.getId())
                .customer_name(request.getCustomer_name())
                .transaction_details(request.getTransaction_details())
                .is_paid(request.getIs_paid())
                .created_at(LocalDateTime.now())
                .build();
        transactionRepository.save(transactionDao);
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS",transactionDao, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
        return ResponseUtil.build( AppConstant.ResponseCode.SUCCESS,"SUCCESS", null,HttpStatus.OK);
    }

}
