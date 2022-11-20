package com.example.demoshopping.repository;

import com.example.demoshopping.entity.Orders;
import com.example.demoshopping.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrdersRepository  extends JpaRepository<Orders,Long> {

    List<Orders> findByorderId(Long orderId);

    @Modifying
    @Transactional
    @Query(
            value = "update shop_orders set order_status = ?1 where order_id = ?2",
            nativeQuery = true
    )
    int updateOrderStatusByOrderID(String orderStatus, Long orderId);

}
