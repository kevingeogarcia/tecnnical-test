package com.kevingeo.api.products.service;

import com.kevingeo.api.products.entity.Products;
import com.kevingeo.api.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public static final String USER_ID = "user-";
    public static final String PRODUCT_ID = "product-";


    public List<Products> findByUserId(Long userId) {
        return productRepository.findByUserId(userId);
    }

    public Products save(@RequestBody Products product) {
        product.setId(USER_ID + product.getUserId().toString() + PRODUCT_ID + product.getIdProduct().toString());
        productRepository.save(product);
        return product;
    }


    public List findAll() {
        return (List) productRepository.findAll();
    }

    public String delete(String id) {
        productRepository.deleteById(id);
        return "delete";
    }

}
