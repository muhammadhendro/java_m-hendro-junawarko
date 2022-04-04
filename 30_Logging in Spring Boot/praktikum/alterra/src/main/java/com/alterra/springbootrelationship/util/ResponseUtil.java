package com.alterra.springbootrelationship.util;

import java.time.LocalDateTime;

import com.alterra.springbootrelationship.constant.AppConstant.ResponseCode;
import com.alterra.springbootrelationship.domain.common.ApiResponse;
import com.alterra.springbootrelationship.domain.common.ApiResponseStatus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    private ResponseUtil() {}

    public static <T> ResponseEntity<Object> build(ResponseCode responseCode, T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(build(responseCode, data), httpStatus);
    }

    private static <T> ApiResponse<T> build(ResponseCode responseCode, T data) {
        return ApiResponse.<T>builder()
            .status(ApiResponseStatus.builder()
                .code(responseCode.getCode())
                .message(responseCode.getMessage())
                .build())
            .timestamp(LocalDateTime.now())
            .data(data)
            .build();
    }
    
    
}
