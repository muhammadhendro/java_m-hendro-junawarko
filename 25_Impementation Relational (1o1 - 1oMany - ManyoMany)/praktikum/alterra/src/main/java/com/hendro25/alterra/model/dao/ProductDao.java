package com.hendro25.alterra.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="M_products")
public class ProductDao {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryDao categoryDao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandDao brandDao;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "product_id", nullable = false)
    private Long id;

    @Column(name= "product_name", nullable = false)
    private String name;


    private Long model_year;

    private BigInteger list_price;

}
