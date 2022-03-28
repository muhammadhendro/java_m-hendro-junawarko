package com.hendro25.alterra.service.impl;

import com.hendro25.alterra.constant.AppConstant;
import com.hendro25.alterra.model.dao.ProductDao;
import com.hendro25.alterra.model.dto.ProductDto;
import com.hendro25.alterra.repository.ProductRepository;
import com.hendro25.alterra.service.ProductService;
import com.hendro25.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

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
    public ResponseEntity<Object> getAllProductByCategory(){
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", productRepository.getAllProductByCategory(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAllProductByPage(){
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", productRepository.findAllByOrderByIdAsc(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> saveProduct(ProductDto request) {
        ProductDao productDao = ProductDao.builder()
                .name(request.getName())
                .model_year(request.getModel_year())
                .list_price(request.getList_price())
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
            res.setModel_year(request.getModel_year());
            res.setList_price(request.getList_price());
            productRepository.save(res);
        });

        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS",productDaoOptional.get(),  HttpStatus.OK);
    }

}
