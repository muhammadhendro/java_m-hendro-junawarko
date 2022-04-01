package com.hendro.alterra.service.impl;

import com.hendro.alterra.constant.AppConstant;
import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.domain.dao.TransactionDao;
import com.hendro.alterra.domain.dao.TransactionDetailDao;
import com.hendro.alterra.domain.dto.TransactionDetailDto;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.repository.TransactionDetailRepository;
import com.hendro.alterra.repository.TransactionRepository;
import com.hendro.alterra.service.TransactionDetailService;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public ResponseEntity<Object> getAllTransactionDetail() {
        List<TransactionDetailDao> daoList = transactionDetailRepository.findAll();
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", daoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> saveTransactionDetail(TransactionDetailDto request) {
        Optional<ProductDao> productDao = productRepository.findById(request.getProduct_id());
        Optional<TransactionDao> transactionDao = transactionRepository.findById(request.getTransaction_id());
        TransactionDetailDao transactionDetailDao = TransactionDetailDao.builder()
                .id(request.getId())
                .transaction_id(transactionDao.get())
                .product_id(productDao.get())
                .quantity(request.getQuantity())
                .build();
        transactionDetailRepository.save(transactionDetailDao);
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS",transactionDetailDao, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> deleteTransactionDetail(Long id) {
        transactionDetailRepository.deleteById(id);
        return ResponseUtil.build( AppConstant.ResponseCode.SUCCESS,"SUCCESS", null,HttpStatus.OK);
    }

}
