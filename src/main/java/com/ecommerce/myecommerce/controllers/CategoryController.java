package com.ecommerce.myecommerce.controllers;

import com.ecommerce.myecommerce.dto.CategoryDTO;
import com.ecommerce.myecommerce.dto.ProductDTO;
import com.ecommerce.myecommerce.dto.ProductMinDTO;
import com.ecommerce.myecommerce.services.CategoryService;
import com.ecommerce.myecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
     List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
}
