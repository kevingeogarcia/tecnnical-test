package com.kevingeo.api.products.controller;

import com.kevingeo.api.products.entity.Products;
import com.kevingeo.api.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @PostMapping
    public Products save(@RequestBody Products product){
        productRepository.save(product);
        return product;
    }

    @GetMapping
    public List list(){
        return productRepository.findAll();
    }

}
