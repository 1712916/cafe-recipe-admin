package com.vinhnt.caferecipeadmin.data.repository;

import com.vinhnt.caferecipeadmin.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}