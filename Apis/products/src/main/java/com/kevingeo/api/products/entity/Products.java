package com.kevingeo.api.products.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Products")
public class Products implements Serializable {

    private static final long serialVersionUID = -7817224776021728682L;

    @Id
    private String id;
    @Indexed
    private Long idProduct;
    @Indexed
    private Long userId;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
    private Integer quantity;


}

