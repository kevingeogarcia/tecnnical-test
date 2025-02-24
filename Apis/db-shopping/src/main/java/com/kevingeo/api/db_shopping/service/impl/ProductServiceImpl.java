package com.kevingeo.api.db_shopping.service.impl;

import com.kevingeo.api.db_shopping.client.ConectorApiClient;
import com.kevingeo.api.db_shopping.entity.Product;
import com.kevingeo.api.db_shopping.repository.ProductRepository;
import com.kevingeo.api.db_shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConectorApiClient apiConnectorClient;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllDto(Integer limit) {
        return apiConnectorClient.getAllProducts(limit).stream().map(e -> {
            return Product.builder()
                    .productId(e.getId() != null ? e.getId() : 0)
                    .productCategory(e.getCategory() != null ? e.getCategory() : "")
                    .productImage(e.getImage() != null ? e.getImage() : "")
                    .productPrice(e.getPrice() != null ? e.getPrice() : new BigDecimal(0))
                    .productTitle(e.getTitle() != null ? e.getTitle() : "")
                    .productDescription(e.getDescription() != null ? e.getDescription() : "")
                    .build();
        }).collect(Collectors.toList());
    }
}
