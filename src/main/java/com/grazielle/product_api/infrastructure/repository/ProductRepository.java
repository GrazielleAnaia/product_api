package com.grazielle.product_api.infrastructure.repository;

import com.grazielle.product_api.infrastructure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
