package com.hendro.alterra.controller;

import com.hendro.alterra.domain.base.BaseResponse;
import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.domain.dto.ProductDto;
import com.hendro.alterra.service.Product2Service;
import com.hendro.alterra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private Product2Service product2Service;


    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return productService.getAllProduct();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto request) {
        return productService.saveProduct(request);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping(value= "/{id}")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody ProductDto request) {
        return productService.updateProductById(id, request);
    }

    @GetMapping(value = "/test")
    public List<Object> getAllTest() {
        return product2Service.getAllProduct();
    }
}
