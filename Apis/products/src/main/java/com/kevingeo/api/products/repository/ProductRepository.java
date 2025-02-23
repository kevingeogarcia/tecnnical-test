package com.kevingeo.api.products.repository;

import com.kevingeo.api.products.entity.Products;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    public static final String PRODUCT_KEY = "PRODUCT";

    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public  ProductRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Products product) {
        hashOperations.put(PRODUCT_KEY, product.getId(), product);
    }

    public List findAll(){
        return hashOperations.values(PRODUCT_KEY);
    }

    public Products findById(String id) {
        return (Products) hashOperations.get(PRODUCT_KEY, id);
    }

    public void update(Products product) {
        save(product);
    }

    public void delete(String id) {
        hashOperations.delete(PRODUCT_KEY, id);
    }



}
