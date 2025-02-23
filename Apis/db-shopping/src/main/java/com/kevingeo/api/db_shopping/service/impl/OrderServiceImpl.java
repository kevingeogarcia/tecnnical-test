package com.kevingeo.api.db_shopping.service.impl;

import com.kevingeo.api.db_shopping.entity.CustomerOrder;
import com.kevingeo.api.db_shopping.repository.CustomerOrderRepository;
import com.kevingeo.api.db_shopping.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrdersService {


    @Autowired
    private CustomerOrderRepository orderRepository;

    @Override
    public CustomerOrder saveOrder(CustomerOrder order) {
        return orderRepository.save(order);
    }
}
