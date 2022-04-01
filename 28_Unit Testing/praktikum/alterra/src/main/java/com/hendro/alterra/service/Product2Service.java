package com.hendro.alterra.service;

import com.hendro.alterra.constant.AppConstant;
import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Product2Service {

    @Autowired
    private ProductRepository productRepository;

    public List<Object> getAllProduct() {
        List<ProductDao> daoList = productRepository.findAll();
        return Collections.singletonList(daoList);
    }
}
