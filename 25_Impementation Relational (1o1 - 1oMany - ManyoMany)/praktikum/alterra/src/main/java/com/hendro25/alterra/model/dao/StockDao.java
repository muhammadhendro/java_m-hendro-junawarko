package com.hendro25.alterra.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Join;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="M_stocks")
public class StockDao {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "product_id")
    private ProductDao productDao;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="stock_id", nullable = false)
    private Long id;


    private Long quantity;


}
