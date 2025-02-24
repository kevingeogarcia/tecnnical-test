package com.kevingeo.api.db_shopping.service.impl;

import com.kevingeo.api.db_shopping.entity.CustomerOrder;
import com.kevingeo.api.db_shopping.entity.OrderDetail;
import com.kevingeo.api.db_shopping.repository.CustomerOrderRepository;
import com.kevingeo.api.db_shopping.repository.OrderDetailRepository;
import com.kevingeo.api.db_shopping.repository.ProductRepository;
import com.kevingeo.api.db_shopping.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrdersService {


    @Autowired
    private CustomerOrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public CustomerOrder saveOrder(CustomerOrder order) {
        return orderRepository.save(order);
    }


    @Override
    public OrderDetail saveOrderDetail(OrderDetail detail) {
        if (!productRepository.existsById(detail.getProduct().getProductId())) {
            detail.setProduct(productRepository.save(detail.getProduct()));
        } else {
            detail.setProduct(productRepository.findById(detail.getProduct().getProductId()).get());
        }
        return orderDetailRepository.save(detail);
    }

}
