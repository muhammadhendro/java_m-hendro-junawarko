package com.hendro.alterra.repository;

import com.hendro.alterra.domain.dao.ProductDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductDao, Long> {
}
