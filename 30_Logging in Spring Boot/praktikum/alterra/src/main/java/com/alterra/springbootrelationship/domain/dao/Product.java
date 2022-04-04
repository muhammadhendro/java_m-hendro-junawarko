package com.alterra.springbootrelationship.domain.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alterra.springbootrelationship.domain.common.BaseDao;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "M_PRODUCT")
@SQLDelete(sql = "UPDATE M_PRODUCT SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Product extends BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    @Column(name = "model_year", nullable = false)
    private String modelYear;

    @Column(name = "price", nullable = false)
    private Integer price;
    
}
