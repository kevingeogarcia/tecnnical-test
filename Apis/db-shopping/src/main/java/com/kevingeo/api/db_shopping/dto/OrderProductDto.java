package com.kevingeo.api.db_shopping.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDto {

    private Long productId;
    private String productTitle;
    private BigDecimal productPrice;
    private String productDescription;
    private String productCategory;
    private String productImage;


}
