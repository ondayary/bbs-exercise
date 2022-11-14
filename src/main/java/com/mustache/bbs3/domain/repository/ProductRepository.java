package com.mustache.bbs3.domain.repository;

import com.mustache.bbs3.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { // <T, ID>
}
