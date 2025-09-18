package com.example.fooddeliveryapp.repostiry;

import com.example.fooddeliveryapp.table.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepostiry extends JpaRepository<Orders, Long> {
}
