package com.hendro.alterra.domain.dao;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "M_Transaction")
public class TransactionDao {

    @Id
    private Long id;

    private String customer_name;

    private String transaction_details;

    private Boolean is_paid;

    private LocalDateTime created_at;

//    @DBRef
//    private List<TransactionDetailDao> transactionDetailDaos;

}
