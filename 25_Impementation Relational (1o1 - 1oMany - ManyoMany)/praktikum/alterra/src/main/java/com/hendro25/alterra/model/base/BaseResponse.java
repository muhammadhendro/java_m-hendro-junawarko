package com.hendro25.alterra.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable {



    private static final long serialVersionUID = 2936580126550389058L;
    private LocalDateTime timestamp;

    private String responseCode;

    private String message;

    private Object data;
}
