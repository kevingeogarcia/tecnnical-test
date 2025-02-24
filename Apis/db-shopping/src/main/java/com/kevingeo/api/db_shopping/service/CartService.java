package com.kevingeo.api.db_shopping.service;

import com.kevingeo.api.db_shopping.dto.ProductsDto;
import com.kevingeo.api.db_shopping.dto.ProductsShoppingCartDto;
import com.kevingeo.api.db_shopping.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CartService {


    public ProductsShoppingCartDto save(@RequestBody Product product);


    public List<ProductsShoppingCartDto> findByUserId(@PathVariable(name = "userId") Long userId);

}
