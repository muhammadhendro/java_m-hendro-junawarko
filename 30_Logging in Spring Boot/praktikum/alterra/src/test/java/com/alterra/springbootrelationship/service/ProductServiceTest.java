package com.alterra.springbootrelationship.service;

import com.alterra.springbootrelationship.constant.AppConstant;
import com.alterra.springbootrelationship.domain.common.ApiResponse;
import com.alterra.springbootrelationship.domain.dao.Brand;
import com.alterra.springbootrelationship.domain.dao.Category;
import com.alterra.springbootrelationship.domain.dao.Product;
import com.alterra.springbootrelationship.domain.dto.BrandDto;
import com.alterra.springbootrelationship.domain.dto.CategoryDto;
import com.alterra.springbootrelationship.domain.dto.ProductDto;
import com.alterra.springbootrelationship.repository.BrandRepository;
import com.alterra.springbootrelationship.repository.CategoryRepository;
import com.alterra.springbootrelationship.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ProductService.class)
class ProductServiceTest {

    @MockBean
    private BrandRepository brandRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @Test
    void addProductSuccess_Test() {
        Category category = Category.builder()
                .id(1L)
                .build();

        Brand brand = Brand.builder()
                .id(1L)
                .build();

        Product product = Product.builder()
                .id(1L)
                .build();

        ProductDto productDto = ProductDto.builder()
                .id(1L)
                .category(CategoryDto.builder().id(1L).build())
                .brand(BrandDto.builder().id(1L).build())
                .productName("New Product")
                .build();

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));
        when(brandRepository.findById(anyLong())).thenReturn(Optional.of(brand));
        when(modelMapper.map(any(), eq(Product.class))).thenReturn(product);
        when(modelMapper.map(any(), eq(ProductDto.class))).thenReturn(productDto);
        when(productRepository.save(any())).thenReturn(product);

        ResponseEntity<Object> responseEntity = productService.addProduct(ProductDto.builder()
                .brand(BrandDto.builder().id(1L).build())
                .category(CategoryDto.builder().id(1L).build())
                .build());

        ApiResponse apiResponse = (ApiResponse) responseEntity.getBody();

        ProductDto productDtoResponse = (ProductDto) Objects.requireNonNull(apiResponse).getData();

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertEquals(AppConstant.ResponseCode.SUCCESS.getCode(), Objects.requireNonNull(apiResponse).getStatus().getCode());
        assertEquals(productDto.getProductName(), productDtoResponse.getProductName());
        assertEquals(productDto.getCategory().getId(), productDtoResponse.getCategory().getId());
    }

    @Test
    void addProductBrandIsEmpty_Test() {
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(Category.builder()
                .id(1L)
                .build()));
        when(brandRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Object> responseEntity = productService.addProduct(ProductDto.builder()
                .brand(BrandDto.builder().id(1L).build())
                .category(CategoryDto.builder().id(1L).build())
                .build());

        ApiResponse apiResponse = (ApiResponse) responseEntity.getBody();
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
        assertEquals(AppConstant.ResponseCode.DATA_NOT_FOUND.getCode(), Objects.requireNonNull(apiResponse).getStatus().getCode());
    }

    @Test
    void addProductCategoryIsEmpty_Test() {
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Object> responseEntity = productService.addProduct(ProductDto.builder()
                .brand(BrandDto.builder().id(1L).build())
                .category(CategoryDto.builder().id(1L).build())
                .build());

        ApiResponse apiResponse = (ApiResponse) responseEntity.getBody();
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
        assertEquals(AppConstant.ResponseCode.DATA_NOT_FOUND.getCode(), Objects.requireNonNull(apiResponse).getStatus().getCode());
    }

    @Test
    void addProductException_Test() {
        when(categoryRepository.findById(anyLong())).thenThrow(NullPointerException.class);

        ResponseEntity<Object> responseEntity = productService.addProduct(ProductDto.builder()
                .brand(BrandDto.builder().id(1L).build())
                .category(CategoryDto.builder().id(1L).build())
                .build());

        ApiResponse apiResponse = (ApiResponse) responseEntity.getBody();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), responseEntity.getStatusCodeValue());
        assertEquals(AppConstant.ResponseCode.UNKNOWN_ERROR.getCode(), Objects.requireNonNull(apiResponse).getStatus().getCode());
    }

    @Test
    void getAllProductCategoryIsNullSuccess_Test() {
        Product product = Product.builder()
                .id(1L)
                .productName("New Product")
                .price(200000)
                .build();
        when(productRepository.findAll()).thenReturn(List.of(product));
        when(modelMapper.map(any(), eq(ProductDto.class)))
                .thenReturn(ProductDto.builder()
                        .id(1L)
                        .productName("New Product")
                        .price(200000)
                        .build());

        ResponseEntity<Object> responseEntity = productService.getAllProduct(null);

        ApiResponse apiResponse = (ApiResponse) responseEntity.getBody();

        List<ProductDto> productDtoList = (List<ProductDto>) apiResponse.getData();

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertEquals(AppConstant.ResponseCode.SUCCESS.getCode(), Objects.requireNonNull(apiResponse).getStatus().getCode());
        assertEquals(1, productDtoList.size());
    }

    @Test
    void getAllProductCategoryIsNotNullSuccess_Test() {
        Product product = Product.builder()
                .id(1L)
                .productName("New Product")
                .price(200000)
                .build();
        when(productRepository.findAllByCategoryId(anyLong())).thenReturn(List.of(product));
        when(modelMapper.map(any(), eq(ProductDto.class)))
                .thenReturn(ProductDto.builder()
                        .id(1L)
                        .productName("New Product")
                        .price(200000)
                        .build());

        ResponseEntity<Object> responseEntity = productService.getAllProduct(1L);

        ApiResponse apiResponse = (ApiResponse) responseEntity.getBody();

        List<ProductDto> productDtoList = (List<ProductDto>) apiResponse.getData();

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertEquals(AppConstant.ResponseCode.SUCCESS.getCode(), Objects.requireNonNull(apiResponse).getStatus().getCode());
        assertEquals(1, productDtoList.size());
    }

}