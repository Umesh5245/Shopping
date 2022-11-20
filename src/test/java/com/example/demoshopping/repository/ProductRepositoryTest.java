package com.example.demoshopping.repository;

import com.example.demoshopping.entity.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    public void saveProducts() {
        Products products = Products.builder()
                .productName("chips1" )
                .price(22.22)
                .Description("chips1")
                .Quantity(10)
                .build();

        productRepository.save(products);
    }
    @Test
    public void printAllProducts() {
        List<Products> productsList =
                productRepository.findAll();

        System.out.println("productsList = " + productsList);
    }
    @Test
    public void printStudentByFirstName() {

        List<Products> Products =
                productRepository.findByproductName("coke");

        System.out.println("Products = " + Products);
    }


}