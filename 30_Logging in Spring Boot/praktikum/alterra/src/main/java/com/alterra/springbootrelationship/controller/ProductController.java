package com.alterra.springbootrelationship.controller;

import com.alterra.springbootrelationship.domain.dto.ProductDto;
import com.alterra.springbootrelationship.domain.dto.ProductListDto;
import com.alterra.springbootrelationship.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    private ProductService productService;

    @PostMapping(value = "")
    public ResponseEntity<Object> createNewProduct(@RequestBody ProductDto request) {
        logger.info("add new product");
        return productService.addProduct(request);
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllProduct(@RequestParam(value = "category_id", required = false) Long categoryId) {
        logger.info("get all product");
        return productService.getAllProduct(categoryId);
    }

    @PostMapping(value = "/pagination")
    public ResponseEntity<Object> getAllProductPagination(@RequestBody ProductListDto request) {
        return productService.getAllProductPagination(request);
    }

    @GetMapping(value = "/sort-by-category")
    public ResponseEntity<Object> getAllProductSortByCategory(@RequestParam(value = "sort", required = true) Sort.Direction direction) {
        return productService.getAllProductSortByCategory(direction);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Object> searchProduct(@RequestParam(value = "product_name") String productName) {
        return productService.searchProductByName(productName);
    }
    
    
}
