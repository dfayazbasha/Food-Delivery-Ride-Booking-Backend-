package com.example.fooddeliveryapp.services;

import com.example.fooddeliveryapp.dto.placeOrderRequest;
import com.example.fooddeliveryapp.repostiry.*;
import com.example.fooddeliveryapp.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServices {

    @Autowired
    private  OrdersRepostiry ordersRepostiry;
    @Autowired
    private  UserRepostiry userRepostiry;
    @Autowired
    private  Restaurentrepostiry restaurentrepostiry;
    @Autowired
    private  Menu_itemsRepostiry menu_itemsRepostiry;
    @Autowired
    private Orderitemrepostiry  orderitemrepostiry;

    public  Orders placeOrder(placeOrderRequest request) {
        Users user = userRepostiry.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Restaurant restaurant = restaurentrepostiry.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        // 2. Create new order
        Orders order = new Orders();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setStatus(Orders.OrderStatus.PLACED);
        order =ordersRepostiry.save(order);




        double totalAmount = 0;

        // 3. Add order items
        for (placeOrderRequest.Item itemReq : request.getItems()) {
            Menu_items menu = menu_itemsRepostiry.findById(itemReq.getMenuId())
                    .orElseThrow(() -> new RuntimeException("Menu item not found"));

            Orderitems orderItem = new Orderitems();
            orderItem.setOrder(order);
            orderItem.setMenu(menu);
            orderItem.setQuantity(itemReq.getQuantity());
            orderItem.setPrice(menu.getPrice() * itemReq.getQuantity());

            totalAmount += orderItem.getPrice();
            orderitemrepostiry.save(orderItem);

        }
        order.setTotalAmount(totalAmount);
        return ordersRepostiry.save(order);
    }


    public Orders updateStatus(Long id, Orders.OrderStatus status) {
        Orders order = ordersRepostiry.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return ordersRepostiry.save(order);
    }


    public Orders getOrderById(Long id) {
        return ordersRepostiry.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

}
