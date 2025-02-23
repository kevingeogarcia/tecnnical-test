package com.kevingeo.api.db_shopping.repository;

import com.kevingeo.api.db_shopping.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
