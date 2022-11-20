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
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(name = "emailid_unique", columnNames = "email_address"))
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    private Long customerID;
    private String firstName;
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;
    private String phone;


}
