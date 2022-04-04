package com.alterra.springbootrelationship.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.alterra.springbootrelationship.constant.AppConstant.ResponseCode;
import com.alterra.springbootrelationship.controller.LoggingController;
import com.alterra.springbootrelationship.domain.dao.Brand;
import com.alterra.springbootrelationship.domain.dao.Category;
import com.alterra.springbootrelationship.domain.dao.Product;
import com.alterra.springbootrelationship.domain.dto.ProductDto;
import com.alterra.springbootrelationship.domain.dto.ProductListDto;
import com.alterra.springbootrelationship.repository.BrandRepository;
import com.alterra.springbootrelationship.repository.CategoryRepository;
import com.alterra.springbootrelationship.repository.ProductRepository;
import com.alterra.springbootrelationship.util.ResponseUtil;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    public ResponseEntity<Object> addProduct(ProductDto request) {
        logger.info("Executing add new product");
        try {
            Optional<Category> category = categoryRepository.findById(request.getCategory().getId());
            if (category.isEmpty()) {
                logger.info("Category [{}] not found", request.getCategory().getId());
                return ResponseUtil.build(ResponseCode.DATA_NOT_FOUND, null, HttpStatus.BAD_REQUEST);
            }

            Optional<Brand> brand = brandRepository.findById(request.getBrand().getId());
            if (brand.isEmpty()) {
                logger.info("Brand [{}] not found", request.getBrand().getId());
                return ResponseUtil.build(ResponseCode.DATA_NOT_FOUND, null, HttpStatus.BAD_REQUEST);
            }

            Product product = mapper.map(request, Product.class);
            product.setBrand(brand.get());
            product.setCategory(category.get());
            productRepository.save(product);
            
            return ResponseUtil.build(ResponseCode.SUCCESS, mapper.map(product, ProductDto.class), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Got an error when saving new product. Error: {}", e.getMessage());
            return ResponseUtil.build(ResponseCode.UNKNOWN_ERROR, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getAllProduct(Long categoryId) {
        try {
            logger.info("Executing get all product by category [{}]", categoryId);
            List<Product> products;
            List<ProductDto> productDtoList = new ArrayList<>();

            if (categoryId != null) products = productRepository.findAllByCategoryId(categoryId);
            else products = productRepository.findAll();

            for (Product product : products) {
                productDtoList.add(mapper.map(product, ProductDto.class));
            }

            return ResponseUtil.build(ResponseCode.SUCCESS, productDtoList, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Got an error when get all product by category. Error: {}", e.getMessage());
            return ResponseUtil.build(ResponseCode.UNKNOWN_ERROR, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getAllProductPagination(ProductListDto request) {
        try {
            logger.info("Executing get all product with pagination");
            int page = null == request.getPage() ? 0 : request.getPage();
            int size = null == request.getSize() ? 1 : request.getSize();
            Pageable pageable = PageRequest.of(page, size);
            Page<Product> productPage = productRepository.findAll(pageable);

            logger.info("Mapping page into dtos. Size: [{}]", productPage.getTotalElements());
            List<ProductDto> productDtoList = new ArrayList<>();
            
            for (Product product : productPage.getContent()) {
                productDtoList.add(mapper.map(product, ProductDto.class));
            }

            ProductListDto productListDto = ProductListDto.builder()
                .products(productDtoList)
                .size(productPage.getSize())
                .page(productPage.getNumber())
                .totalPage(productPage.getTotalPages())
                .build();

                return ResponseUtil.build(ResponseCode.SUCCESS, productListDto, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Got an error when get all product with pagination. Error: {}", e.getMessage());
            return ResponseUtil.build(ResponseCode.UNKNOWN_ERROR, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getAllProductSortByCategory(Sort.Direction direction) {
        try {
            logger.info("Executing get all product sort by category [{}]", direction);
            List<Product> products = productRepository.findAll(Sort.by(direction, "category.id"));
            List<ProductDto> productDtoList = new ArrayList<>();
        
            for (Product product : products) {
                productDtoList.add(mapper.map(product, ProductDto.class));
            }

            return ResponseUtil.build(ResponseCode.SUCCESS, productDtoList, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Got an error when get all product sort by category. Error: {}", e.getMessage());
            return ResponseUtil.build(ResponseCode.UNKNOWN_ERROR, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> searchProductByName(String productName) {
        try {
            logger.info("Executing search product by name: [{}]", productName);
            Product product = productRepository.findByProductNameContaining(productName);

            return ResponseUtil.build(ResponseCode.SUCCESS, mapper.map(product, ProductDto.class), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Got an error when search product by product name. Error: {}", e.getMessage());
            return ResponseUtil.build(ResponseCode.UNKNOWN_ERROR, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
