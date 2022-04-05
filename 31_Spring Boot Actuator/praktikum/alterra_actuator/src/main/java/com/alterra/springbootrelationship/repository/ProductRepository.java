package com.alterra.springbootrelationship.repository;

import java.util.List;

import com.alterra.springbootrelationship.domain.dao.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findAllByCategoryId(Long categoryId);

    Product findByProductNameContaining(String productName);

}
