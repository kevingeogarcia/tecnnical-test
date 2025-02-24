package com.kevingeo.api.db_shopping.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {


    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
}

