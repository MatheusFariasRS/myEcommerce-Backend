package com.ecommerce.myecommerce.controllers;

import com.ecommerce.myecommerce.dto.ProductDTO;
import com.ecommerce.myecommerce.entities.Product;
import com.ecommerce.myecommerce.repositories.ProductRepository;
import com.ecommerce.myecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        /*
        ProductDTO dto = service.findById(id);
        return dto;*/
        return service.findById(id);
    }
}
