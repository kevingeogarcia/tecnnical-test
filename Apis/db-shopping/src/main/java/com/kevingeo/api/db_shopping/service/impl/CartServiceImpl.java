package com.kevingeo.api.db_shopping.service.impl;

import com.kevingeo.api.db_shopping.client.ProductApiClient;
import com.kevingeo.api.db_shopping.dto.ProductsShoppingCartDto;
import com.kevingeo.api.db_shopping.entity.Product;
import com.kevingeo.api.db_shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductApiClient productApiClient;

    @Override
    public List<ProductsShoppingCartDto> findByUserId(Long userId) {
        return productApiClient.findById(userId);
    }

    @Override
    public ProductsShoppingCartDto save(Product product) {
        ProductsShoppingCartDto productsShoppingCartDto = ProductsShoppingCartDto.builder()
                .quantity(product.getQuantity())
                .image(product.getProductImage())
                .price(product.getProductPrice())
                .title(product.getProductTitle())
                .category(product.getProductCategory())
                .idProduct(product.getProductId())
                .description(product.getProductDescription())
                .userId(product.getUserId())
                .build();
        return productApiClient.save(productsShoppingCartDto);
    }
}
