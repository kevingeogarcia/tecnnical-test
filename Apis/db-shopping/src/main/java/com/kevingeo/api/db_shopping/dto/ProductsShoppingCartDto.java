package com.kevingeo.api.db_shopping.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductsShoppingCartDto {


    private String id;
    private Long idProduct;
    private Long userId;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
    private Integer quantity;
}

