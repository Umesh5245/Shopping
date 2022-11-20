package com.example.demoshopping.repository;

import com.example.demoshopping.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByproductName(String name);

    List<Products> findByProductId(Long id);
}
