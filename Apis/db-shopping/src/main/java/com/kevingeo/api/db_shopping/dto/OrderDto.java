package com.kevingeo.api.db_shopping.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long customerOrderId;
    private LocalDate customerOrderDate;
    private BigDecimal customerOrderPrice;
    private CustomerDto customer;
    private List<OrderDetailDto> detail;
}
