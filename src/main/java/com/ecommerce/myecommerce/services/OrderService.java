package com.ecommerce.myecommerce.services;

import com.ecommerce.myecommerce.dto.OrderDTO;
import com.ecommerce.myecommerce.entities.Order;
import com.ecommerce.myecommerce.repositories.OrderRepository;
import com.ecommerce.myecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

}
