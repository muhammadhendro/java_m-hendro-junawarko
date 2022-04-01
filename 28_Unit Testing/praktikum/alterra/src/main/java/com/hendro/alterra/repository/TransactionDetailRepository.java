package com.hendro.alterra.repository;

import com.hendro.alterra.domain.dao.TransactionDetailDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends MongoRepository<TransactionDetailDao, Long> {
}
