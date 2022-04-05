package com.alterra.springbootrelationship.service;

import com.alterra.springbootrelationship.constant.AppConstant.ResponseCode;
import com.alterra.springbootrelationship.domain.dao.Brand;
import com.alterra.springbootrelationship.domain.dto.BrandDto;
import com.alterra.springbootrelationship.repository.BrandRepository;
import com.alterra.springbootrelationship.util.ResponseUtil;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Service
public class BrandService {
    
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper mapper;

    public ResponseEntity<Object> addBrand(BrandDto request) {
        log.info("Executing save new brand");
        try {
            Brand brand = mapper.map(request, Brand.class);
            brandRepository.save(brand);

            BrandDto brandDto = mapper.map(brand, BrandDto.class);
            return ResponseUtil.build(ResponseCode.SUCCESS, brandDto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Got an error when saving new brand. Error: {}", e.getMessage());
            return ResponseUtil.build(ResponseCode.UNKNOWN_ERROR, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> deleteBrand(Long id) {
        log.info("Executing delete brand");
        try {
            log.info("Find brand by id");
            Optional<Brand> brandOptional = brandRepository.findById(id);
            if (brandOptional.isEmpty()) {
                log.info("brand not found");
                return ResponseUtil.build(ResponseCode.DATA_NOT_FOUND, null, HttpStatus.BAD_REQUEST);
            }

            log.info("Deleting brand {}", id);
            brandRepository.delete(brandOptional.get());
            return ResponseUtil.build(ResponseCode.SUCCESS, null, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Got an error when deleting brand. Error: {}", e.getMessage());
            throw e;
        }
    }

}
