package com.hendro.alterra.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransactionDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -7266906708098463821L;

    private Long id;

    private String customer_name;

    private String transaction_details;

    private Boolean is_paid;

}
