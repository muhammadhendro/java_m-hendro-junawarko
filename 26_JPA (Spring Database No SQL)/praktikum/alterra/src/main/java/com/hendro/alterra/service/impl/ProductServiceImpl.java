package com.hendro.alterra.service.impl;


import com.hendro.alterra.constant.AppConstant;
import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.domain.dto.ProductDto;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.service.ProductService;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<Object> getAllProduct() {
        List<ProductDao> daoList = productRepository.findAll();
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", daoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getProductById(Long id) {
        Optional<ProductDao> productDaoOptional = productRepository.findById(id);
        if(productDaoOptional.isEmpty()){
            return ResponseUtil.build( AppConstant.ResponseCode.NOT_FOUND, "DATA_NOT_FOUND",null, HttpStatus.BAD_REQUEST);
        }
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS", productDaoOptional.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> saveProduct(ProductDto request) {
        ProductDao productDao = ProductDao.builder()
                .id(request.getId())
                .name(request.getName())
                .price(request.getPrice())
                .build();
        productRepository.save(productDao);
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS",productDao, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return ResponseUtil.build( AppConstant.ResponseCode.SUCCESS,"SUCCESS", null,HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Object> updateProductById(Long id, ProductDto request) {
        Optional<ProductDao> productDaoOptional = productRepository.findById(id);

        if(productDaoOptional.isEmpty()){
            return ResponseUtil.build(AppConstant.ResponseCode.NOT_FOUND,"DATA_NOT_FOUND", null,HttpStatus.BAD_REQUEST);
        }

        productDaoOptional.ifPresent(res -> {
            res.setName(request.getName());
            res.setPrice(request.getPrice());
            productRepository.save(res);
        });

        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS",productDaoOptional.get(),  HttpStatus.OK);
    }
}
