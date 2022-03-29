package com.hendro.alterra.repository;

import com.hendro.alterra.domain.dao.TransactionDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionDao, Long> {
}
