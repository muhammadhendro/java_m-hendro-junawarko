package com.hendro.alterra.domain.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hendro.alterra.domain.dto.TransactionDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "M_Product")
public class ProductDao {

    @Id
    private Long id;

    private String name;

    private Integer price;

//    @DBRef
//    private List<TransactionDetailDao> transactionDetailDaos;

}
