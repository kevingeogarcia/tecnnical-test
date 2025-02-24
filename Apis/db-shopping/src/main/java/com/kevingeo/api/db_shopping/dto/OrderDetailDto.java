package com.kevingeo.api.db_shopping.dto;

import lombok.*;


@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {


    private Long orderDetailId;
    private Integer quantity;
    private OrderProductDto product;
    private Long customerOrderId;
}
