package com.kevingeo.api.db_shopping.client;

import com.kevingeo.api.db_shopping.dto.ProductsShoppingCartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${feign.client.product.name}", url = "${feign.client.product.url}")
public interface ProductApiClient {


    @PostMapping("/product")
    public ProductsShoppingCartDto save(@RequestBody ProductsShoppingCartDto product);


    @GetMapping("/product/user/{userId}")
    public List<ProductsShoppingCartDto> findById(@PathVariable(name = "userId") Long userId);

    @DeleteMapping("/product/{id}")
    public String deleteById(@PathVariable(name = "id") String id);
}
