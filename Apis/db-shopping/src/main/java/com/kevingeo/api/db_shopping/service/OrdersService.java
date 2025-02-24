package com.kevingeo.api.db_shopping.service;

import com.kevingeo.api.db_shopping.dto.OrderDto;
import com.kevingeo.api.db_shopping.entity.CustomerOrder;
import com.kevingeo.api.db_shopping.entity.OrderDetail;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface OrdersService {


    /**
     * method to save Order
     *
     * @param order
     * @return
     */
    CustomerOrder saveOrder(CustomerOrder order);

    /**
     * method to save detail order and validate if exist the product in the data base
     *
     * @param detail
     * @return
     */
    OrderDetail saveOrderDetail(OrderDetail detail);


    /**
     * methos to save all data to order
     * product, order, detail
     *
     * @param dto
     * @return
     */
    CustomerOrder registerOrder(OrderDto dto);

    OrderDto getRegisterOrder(Long dto) throws ChangeSetPersister.NotFoundException;
}
