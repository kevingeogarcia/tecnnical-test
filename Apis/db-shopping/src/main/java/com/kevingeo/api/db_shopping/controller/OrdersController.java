package com.kevingeo.api.db_shopping.controller;

import com.kevingeo.api.db_shopping.dto.OrderDto;
import com.kevingeo.api.db_shopping.entity.CustomerOrder;
import com.kevingeo.api.db_shopping.entity.OrderDetail;
import com.kevingeo.api.db_shopping.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {


    @Autowired
    private OrdersService ordersService;


    @PostMapping
    CustomerOrder saveOrder(@RequestBody CustomerOrder order) {
        return ordersService.saveOrder(order);

    }

    @PostMapping("/detail")
    OrderDetail saveOrderDetail(@RequestBody OrderDetail detail) {
        return ordersService.saveOrderDetail(detail);

    }


    @PostMapping("/register")
    CustomerOrder registerOrder(@RequestBody OrderDto dto) {
        return ordersService.registerOrder(dto);

    }

    @GetMapping("/register/{orderId}")
    OrderDto registerOrder(@PathVariable(name = "orderId") Long orderId) {
        return ordersService.getRegisterOrder(orderId);

    }

    @GetMapping("/register")
    List<OrderDto> registerOrders() {
        return ordersService.getRegisterOrders();

    }


}
