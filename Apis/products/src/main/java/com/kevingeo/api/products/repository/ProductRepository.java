package com.kevingeo.api.products.repository;

import com.kevingeo.api.products.entity.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Products, String> {

     List<Products> getAllUserId(Long userId);
     List<Products> findByUserId(Long userId);

//    public static final String PRODUCT_KEY = "PRODUCT";
//    public static final String USER_ID = "user-";
//    public static final String PRODUCT_ID = "product-";
//
//
//    private HashOperations hashOperations;
//
//    private RedisTemplate redisTemplate;
//
//    public ProductRepository(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//        this.hashOperations = this.redisTemplate.opsForHash();
//    }
//
//    public void save(Products product) {
//        System.out.println(USER_ID + product.getUserId().toString() + PRODUCT_ID + product.getId().toString());
//        hashOperations.put(PRODUCT_KEY, USER_ID + product.getUserId().toString() + PRODUCT_ID + product.getId().toString(), product);
//    }
//
//    public List findAll() {
//        return hashOperations.values(PRODUCT_KEY);
//    }
//
//    public List<Products> findAllUser(Long userId) {
//        List<Products> lsResponse = new ArrayList<>();
//        ScanOptions scanOptions = ScanOptions.scanOptions().match(USER_ID+ userId.toString()+"*").build();
//        System.out.println(scanOptions.toOptionString());
//        Cursor c = redisTemplate.scan(scanOptions);
//        lsResponse.add( (Products) hashOperations.get(PRODUCT_KEY,"user-22product-1"));
//        while (c.hasNext()){
//            System.out.println(c.getId());
//        }
//        return lsResponse;
//    }
//
//    public Products findByUserId(Long userId) {
//        return (Products) hashOperations.get(PRODUCT_KEY, userId);
//    }
//
//
//    public void update(Products product) {
//        save(product);
//    }
//
//    public void delete(Long id) {
//        hashOperations.delete(PRODUCT_KEY, id);
//    }


}
