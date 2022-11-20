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
@Table(name = "shop_orders", uniqueConstraints = @UniqueConstraint(name = "orderId_unique", columnNames = "orderId"))
public class Orders {
    @Id
    @SequenceGenerator(
            name = "orderId_sequence",
            sequenceName = "orderId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderId_sequence"
    )
    private Long orderId;
    private String Quantity;
    private String productId;
    private long customer_id;
    private double total;
    private String orderStatus;

}
