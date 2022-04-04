package com.alterra.springbootrelationship.domain.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "M_BRAND")
@SQLDelete(sql = "UPDATE M_BRAND SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Brand extends BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "brand")
    private List<Product> products;
    
}
