package com.kevingeo.api.db_shopping.controller;

import com.kevingeo.api.db_shopping.entity.Product;
import com.kevingeo.api.db_shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/connector-api")
    public List<Product> getAll(@RequestParam(name = "limit", defaultValue = "20") Integer limit) {
        System.out.println(limit);
        return productService.getAllDto(limit);
    }


}
