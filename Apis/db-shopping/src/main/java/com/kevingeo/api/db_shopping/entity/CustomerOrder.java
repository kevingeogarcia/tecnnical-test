package com.kevingeo.api.db_shopping.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_order_id")
    private Long customerOrderId;

    @Column(name = "customer_order_date")
    private LocalDate customerOrderDate;

    @Column(name = "customer_order_price")
    private BigDecimal customerOrderPrice;

    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;


}
