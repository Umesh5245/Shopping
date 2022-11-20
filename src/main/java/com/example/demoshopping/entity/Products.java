package com.example.demoshopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shop_products", uniqueConstraints = @UniqueConstraint(name = "productId_unique", columnNames = "productId"))
public class Products {

    @Id
    @SequenceGenerator(name = "productId_sequence", sequenceName = "productId_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productId_sequence")
    private long productId;
    private String productName;
    private String Description;
    private int Quantity;
    private double price;
}
