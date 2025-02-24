package com.kevingeo.api.db_shopping.client;

import com.kevingeo.api.db_shopping.dto.ProductsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${feign.client.connector.name}", url = "${feign.client.connector.url}")
public interface ConectorApiClient {

    @GetMapping("/fakeStoreProduct")
    List<ProductsDto> getAllProducts(@RequestParam(name = "limit", defaultValue = "10") Integer limit);
}
