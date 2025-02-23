package com.kevingeo.api.fakestoreapi.conector.controller;

import com.kevingeo.api.fakestoreapi.conector.ServiceImpl.FakeStoreProductServiceImpl;
import com.kevingeo.api.fakestoreapi.conector.dto.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fakeStoreProduct")
public class ProductFakestoreController {

    @Autowired
    private FakeStoreProductServiceImpl fakeStoreProductService;

    @GetMapping
    public List<Products> getAllProducts(@RequestParam(name = "limit", defaultValue = "10") Integer limit) {
        return fakeStoreProductService.getAllProducts(limit);

    }
}
