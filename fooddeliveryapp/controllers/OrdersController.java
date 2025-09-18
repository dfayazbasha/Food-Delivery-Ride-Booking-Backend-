package com.example.fooddeliveryapp.controllers;

import com.example.fooddeliveryapp.services.OrdersServices;
import com.example.fooddeliveryapp.table.Orders;
import com.example.fooddeliveryapp.dto.placeOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersServices ordersServices;

    @PostMapping("/placeorder")
    public Orders placeOrder(@RequestBody placeOrderRequest request) {
        return ordersServices.placeOrder(request);
    }

    @PutMapping("/{id}/status")
    public Orders updateOrderStatus(@PathVariable Long id, @RequestBody Orders.OrderStatus status) {

        return ordersServices.updateStatus(id,status);
    }


    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return ordersServices.getOrderById(id);
    }

}
