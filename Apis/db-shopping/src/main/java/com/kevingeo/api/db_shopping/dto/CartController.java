package com.kevingeo.api.db_shopping.dto;

import com.kevingeo.api.db_shopping.entity.Product;
import com.kevingeo.api.db_shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/shopping-cart")
public class CartController {


    @Autowired
    private CartService cartService;

    @PostMapping
    public ProductsShoppingCartDto save(@RequestBody Product product) {
        return  cartService.save(product);
    }


    @GetMapping("user/{userId}")
    public List<ProductsShoppingCartDto> findById(@PathVariable(name = "userId") Long userId) {
        return cartService.findByUserId(userId);
    }


}
