package com.kevingeo.api.db_shopping.controller;

import com.kevingeo.api.db_shopping.entity.CustomerOrder;
import com.kevingeo.api.db_shopping.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrdersController {


    @Autowired
    private OrdersService ordersService;


    @PostMapping
    CustomerOrder saveOrder(@RequestBody CustomerOrder order) {
        return ordersService.saveOrder(order);

    }
}
