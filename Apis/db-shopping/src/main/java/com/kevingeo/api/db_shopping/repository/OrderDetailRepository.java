package com.kevingeo.api.db_shopping.repository;

import com.kevingeo.api.db_shopping.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query("select o from OrderDetail o where o.customerOrderId = :customerOrderId")
    List<OrderDetail> findAllByCustomerOrderId(Long customerOrderId);


}
