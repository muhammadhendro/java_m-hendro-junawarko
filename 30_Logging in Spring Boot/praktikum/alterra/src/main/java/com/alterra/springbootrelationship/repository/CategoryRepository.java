package com.alterra.springbootrelationship.repository;

import com.alterra.springbootrelationship.domain.dao.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
