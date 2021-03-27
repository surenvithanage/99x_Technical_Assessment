package com.web.technical.assessment.server.repository;

import com.web.technical.assessment.server.mapping.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCode(String code);

    List<Product> findByName(String name);
}
