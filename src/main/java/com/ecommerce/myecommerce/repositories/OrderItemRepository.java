package com.ecommerce.myecommerce.repositories;


import com.ecommerce.myecommerce.entities.Order;
import com.ecommerce.myecommerce.entities.OrderItem;
import com.ecommerce.myecommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
