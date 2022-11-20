package com.example.demoshopping.repository;

import com.example.demoshopping.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositor extends JpaRepository<Customer, Long> {
    List<Customer> findByemailId(String email);

}
