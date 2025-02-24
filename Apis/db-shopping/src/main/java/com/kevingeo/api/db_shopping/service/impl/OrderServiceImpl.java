package com.kevingeo.api.db_shopping.service.impl;

import com.kevingeo.api.db_shopping.dto.CustomerDto;
import com.kevingeo.api.db_shopping.dto.OrderDetailDto;
import com.kevingeo.api.db_shopping.dto.OrderDto;
import com.kevingeo.api.db_shopping.dto.OrderProductDto;
import com.kevingeo.api.db_shopping.entity.Customer;
import com.kevingeo.api.db_shopping.entity.CustomerOrder;
import com.kevingeo.api.db_shopping.entity.OrderDetail;
import com.kevingeo.api.db_shopping.entity.Product;
import com.kevingeo.api.db_shopping.repository.CustomerOrderRepository;
import com.kevingeo.api.db_shopping.repository.CustomerRepository;
import com.kevingeo.api.db_shopping.repository.OrderDetailRepository;
import com.kevingeo.api.db_shopping.repository.ProductRepository;
import com.kevingeo.api.db_shopping.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
public class OrderServiceImpl implements OrdersService {


    @Autowired
    private CustomerOrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

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


    @Override
    public CustomerOrder registerOrder(OrderDto dto) {
        AtomicReference<BigDecimal> totalPrice = new AtomicReference<>(new BigDecimal(0));
        Customer customer = Customer.builder()
                .customerId(dto.getCustomer().getCustomerId()).build();
        CustomerOrder customerOrder = CustomerOrder.builder()
                .customerOrderDate(dto.getCustomerOrderDate())
                .customerOrderPrice(dto.getCustomerOrderPrice())
                .customer(customer).build();
        customerOrder = orderRepository.save(customerOrder);
        Long orderId = customerOrder.getCustomerOrderId();
        dto.getDetail().forEach(detail -> {
            Product productDetail = Product.builder()
                    .productId(detail.getProduct().getProductId())
                    .productCategory(detail.getProduct().getProductCategory())
                    .productImage(detail.getProduct().getProductImage())
                    .productDescription(detail.getProduct().getProductDescription())
                    .productTitle(detail.getProduct().getProductTitle())
                    .productPrice(detail.getProduct().getProductPrice())
                    .build();
            totalPrice.set(totalPrice.get().add(productDetail.getProductPrice().multiply(new BigDecimal(detail.getQuantity()))));
            OrderDetail orderDetail = OrderDetail.builder()
                    .customerOrderId(orderId)
                    .quantity(detail.getQuantity())
                    .product(productDetail).build();

            saveOrderDetail(orderDetail);
        });
        customerOrder.setCustomerOrderPrice(totalPrice.get());
        return orderRepository.save(customerOrder);
    }


    @Override
    public OrderDto getRegisterOrder(Long orderId) throws ChangeSetPersister.NotFoundException {

        List<OrderDetailDto> lsDetail = new ArrayList<>();
        CustomerOrder customerOrder = orderRepository.findById(orderId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        Customer customer = customerRepository.findById(customerOrder.getCustomer().getCustomerId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
        CustomerDto customerDto = CustomerDto.builder()
                .customerDui(customer.getCustomerDui())
                .customerAddress(customer.getCustomerAddress())
                .customerName(customer.getCustomerName())
                .customerId(customer.getCustomerId())
                .customerNumber(customer.getCustomerNumber())
                .build();

        OrderDto response = OrderDto.builder()
                .customerOrderDate(customerOrder.getCustomerOrderDate())
                .customerOrderPrice(customerOrder.getCustomerOrderPrice())
                .customer(customerDto)
                .customerOrderId(customerOrder.getCustomerOrderId())
                .build();

        System.out.println(orderDetailRepository.findAllByCustomerOrderId(response.getCustomerOrderId()).size());
        orderDetailRepository.findAllByCustomerOrderId(response.getCustomerOrderId()).forEach(detail -> {
            Product product = productRepository.findById(detail.getProduct().getProductId()).get();
            OrderProductDto productDto = OrderProductDto.builder()
                    .productCategory(product.getProductCategory())
                    .productDescription(product.getProductDescription())
                    .productImage(product.getProductImage())
                    .productPrice(product.getProductPrice())
                    .productTitle(product.getProductTitle())
                    .productId(product.getProductId())
                    .build();
            OrderDetailDto orderDetailDto = OrderDetailDto.builder()
                    .orderDetailId(detail.getOrderDetailId())
                    .customerOrderId(detail.getCustomerOrderId())
                    .quantity(detail.getQuantity())
                    .product(productDto).
                    build();
            lsDetail.add(orderDetailDto);

        });
        response.setDetail(lsDetail);
        return response;
    }
}
