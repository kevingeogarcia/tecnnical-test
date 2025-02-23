package com.kevingeo.api.products.entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Products implements Serializable {

    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;

}

