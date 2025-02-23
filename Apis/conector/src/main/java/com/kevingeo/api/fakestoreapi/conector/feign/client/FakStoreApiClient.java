package com.kevingeo.api.fakestoreapi.conector.feign.client;


import com.kevingeo.api.fakestoreapi.conector.dto.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${feign.client.connector.name}", url = "${feign.client.connector.url}")
public interface FakStoreApiClient {


    @GetMapping
    List<Products> getAllProduct(@RequestParam(name = "limit") Integer limit);
}
