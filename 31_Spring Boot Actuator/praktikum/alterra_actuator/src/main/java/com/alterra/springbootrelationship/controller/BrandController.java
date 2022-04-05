package com.alterra.springbootrelationship.controller;

import com.alterra.springbootrelationship.domain.dto.BrandDto;
import com.alterra.springbootrelationship.service.BrandService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/v1/brand", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping(value = "")
    public ResponseEntity<Object> createNewBrand(@RequestBody BrandDto request) {
        try {
            return brandService.addBrand(request);
        } catch (Exception e) {
            log.error("Happened error when request add brand. Error: {}", e.getMessage());
            throw e;
        }
    }
    
}
