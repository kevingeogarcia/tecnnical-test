package com.kevingeo.api.db_shopping.service.impl;

import com.kevingeo.api.db_shopping.entity.Customer;
import com.kevingeo.api.db_shopping.repository.CustomerRepository;
import com.kevingeo.api.db_shopping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> GetAll() {
        return customerRepository.findAll();
    }
}
