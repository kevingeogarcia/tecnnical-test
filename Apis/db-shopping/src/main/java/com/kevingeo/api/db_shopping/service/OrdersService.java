package com.kevingeo.api.db_shopping.service;

import com.kevingeo.api.db_shopping.entity.CustomerOrder;
import com.kevingeo.api.db_shopping.entity.OrderDetail;

public interface OrdersService {


    CustomerOrder saveOrder(CustomerOrder order);

    OrderDetail saveOrderDetail(OrderDetail detail);
}
