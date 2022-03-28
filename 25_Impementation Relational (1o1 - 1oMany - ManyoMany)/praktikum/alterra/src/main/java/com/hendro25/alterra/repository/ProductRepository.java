package com.hendro25.alterra.repository;

import com.hendro25.alterra.model.dao.ProductDao;
import com.hendro25.alterra.model.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {

    @Query(value= "SELECT p FROM ProductDao p GROUP BY p.categoryDao.id ")
    public List<ProductDao> getAllProductByCategory();

    public List<ProductDao> findAllByOrderByIdAsc();

    public List<ProductDao> findByNameContaining(String name);

}
