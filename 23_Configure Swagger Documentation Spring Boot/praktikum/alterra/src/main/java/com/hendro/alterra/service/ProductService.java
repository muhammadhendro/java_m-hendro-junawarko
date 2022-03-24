package com.hendro.alterra.service;

import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.domain.dto.ProductDto;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.util.ResponseUtil;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> getAllProduct() {
        return ResponseUtil.build(productRepository.findAll(), "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> getProductById(Long id) {
        Optional<ProductDao> productDaoOptional = productRepository.findById(id);
        if(productDaoOptional.isEmpty()){
            return ResponseUtil.build(null,"DATA_NOT_FOUND", HttpStatus.BAD_REQUEST);
        }
        return ResponseUtil.build(productDaoOptional.get(), "SUCCESS", HttpStatus.OK);
    }

    public ResponseEntity<Object> saveProduct(ProductDto request) {
        ProductDao productDao = ProductDao.builder()
                .product(request.getProduct())
                .build();
        

    }
}
