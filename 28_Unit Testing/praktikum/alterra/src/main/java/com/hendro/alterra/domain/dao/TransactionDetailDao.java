package com.hendro.alterra.domain.dao;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "M_TransactionDetail")
public class TransactionDetailDao {

    @Id
    private Long id;

    private TransactionDao transaction_id;

    private ProductDao product_id;

    private Long quantity;

//    @DBRef
//    private List<ProductDao> productDaos;
}
