package com.kevingeo.api.db_shopping.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer", schema = "public")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_addres")
    private String customerAddress;

    @Column(name = "customer_dui")
    private String customerDui;

    @Column(name = "customer_number")
    private String customerNumber;

}

