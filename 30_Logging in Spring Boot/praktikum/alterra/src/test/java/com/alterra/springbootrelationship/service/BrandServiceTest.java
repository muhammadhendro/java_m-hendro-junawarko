package com.alterra.springbootrelationship.service;

import com.alterra.springbootrelationship.constant.AppConstant;
import com.alterra.springbootrelationship.domain.common.ApiResponse;
import com.alterra.springbootrelationship.domain.dao.Brand;
import com.alterra.springbootrelationship.domain.dto.BrandDto;
import com.alterra.springbootrelationship.repository.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BrandService.class)
class BrandServiceTest {

    @MockBean
    private BrandRepository brandRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private BrandService brandService;

    @Test
    void addBrandSuccess_Test() {
        Brand brand = Brand.builder()
                .id(1L)
                .brandName("My Brand")
                .createdAt(LocalDateTime.now())
                .createdBy(AppConstant.DEFAULT_SYSTEM)
                .build();
        BrandDto brandDto = BrandDto.builder()
                .id(1L)
                .brandName("My Brand")
                .build();
        when(modelMapper.map(any(), eq(Brand.class))).thenReturn(brand);
        when(modelMapper.map(any(), eq(BrandDto.class))).thenReturn(brandDto);
        when(brandRepository.save(any())).thenReturn(brand);

        ResponseEntity<Object> responseEntity = brandService.addBrand(BrandDto.builder()
                .brandName("My Brand")
                .build());

        ApiResponse apiResponse = (ApiResponse) responseEntity.getBody();
        BrandDto data = (BrandDto) Objects.requireNonNull(apiResponse).getData();
        assertEquals(1L, data.getId());
        assertEquals("My Brand", data.getBrandName());
    }

    @Test
    void addBrandUnknownError_Test() {
        when(brandRepository.save(any())).thenThrow(NullPointerException.class);
        ApiResponse response = (ApiResponse) brandService.addBrand(BrandDto.builder()
                .brandName("My Brand")
                .build()).getBody();
        assertEquals(AppConstant.ResponseCode.UNKNOWN_ERROR.getCode(), Objects.requireNonNull(response).getStatus().getCode());
    }

    @Test
    void deleteBrandSuccess_Test() {
        when(brandRepository.findById(anyLong())).thenReturn(Optional.of(Brand.builder()
                .id(1L)
                .createdBy("SYSTEM")
                .createdAt(LocalDateTime.now())
                .brandName("Any Brand")
                .build()));
        doNothing().when(brandRepository).delete(any());

        ApiResponse response = (ApiResponse) brandService.deleteBrand(1L).getBody();
        assertEquals(AppConstant.ResponseCode.SUCCESS.getCode(), Objects.requireNonNull(response).getStatus().getCode());
        verify(brandRepository, times(1)).delete(any());
    }

    @Test
    void deleteBrandNotFound_Test() {
        when(brandRepository.findById(anyLong())).thenReturn(Optional.empty());

        ApiResponse response = (ApiResponse) brandService.deleteBrand(1L).getBody();
        assertEquals(AppConstant.ResponseCode.DATA_NOT_FOUND.getCode(), Objects.requireNonNull(response).getStatus().getCode());
    }

    @Test
    void deleteBrandException_Test() {
        when(brandRepository.findById(anyLong())).thenReturn(Optional.of(Brand.builder()
                .id(1L)
                .createdBy("SYSTEM")
                .createdAt(LocalDateTime.now())
                .brandName("Any Brand")
                .build()));
        doThrow(NullPointerException.class).when(brandRepository).delete(any());
        assertThrows(Exception.class, () -> brandService.deleteBrand(1L));
    }

}