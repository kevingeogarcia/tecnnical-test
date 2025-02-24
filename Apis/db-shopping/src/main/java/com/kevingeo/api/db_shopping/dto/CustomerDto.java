package com.kevingeo.api.db_shopping.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerDui;
    private String customerNumber;
}
