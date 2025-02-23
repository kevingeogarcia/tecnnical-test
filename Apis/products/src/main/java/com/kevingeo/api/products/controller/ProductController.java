package com.kevingeo.api.products.controller;

import com.kevingeo.api.products.entity.Products;
import com.kevingeo.api.products.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductServiceImpl productService;


    @PostMapping
    public Products save(@RequestBody Products product) {
        productService.save(product);
        return product;
    }

    @GetMapping
    public List list() {
        return (List) productService.findAll();
    }


    @GetMapping("user/{userId}")
    public List<Products> findById(@PathVariable(name = "userId") Long userId) {
        return productService.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(name = "id") String id) {
        productService.delete(id);
        return "deleted...";
    }
    }

}
