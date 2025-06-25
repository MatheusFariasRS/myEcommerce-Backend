package com.ecommerce.myecommerce.repositories;

import com.ecommerce.myecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {


}
