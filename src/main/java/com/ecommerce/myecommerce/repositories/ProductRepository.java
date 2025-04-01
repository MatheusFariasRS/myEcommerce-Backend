package com.ecommerce.myecommerce.repositories;

import com.ecommerce.myecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
