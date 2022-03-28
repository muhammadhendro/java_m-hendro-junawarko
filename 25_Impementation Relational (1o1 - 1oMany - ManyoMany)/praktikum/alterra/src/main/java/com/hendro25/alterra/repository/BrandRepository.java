package com.hendro25.alterra.repository;

import com.hendro25.alterra.model.dao.BrandDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandDao, Long> {
}
