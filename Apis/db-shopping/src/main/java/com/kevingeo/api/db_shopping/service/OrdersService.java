package com.kevingeo.api.db_shopping.service;

import com.kevingeo.api.db_shopping.entity.CustomerOrder;

public interface OrdersService {


    CustomerOrder saveOrder(CustomerOrder order);
}
