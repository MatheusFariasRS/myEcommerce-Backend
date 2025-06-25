package com.ecommerce.myecommerce.repositories;


import com.ecommerce.myecommerce.entities.Order;
import com.ecommerce.myecommerce.entities.User;
import com.ecommerce.myecommerce.projection.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
