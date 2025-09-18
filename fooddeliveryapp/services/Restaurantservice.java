package com.example.fooddeliveryapp.services;

import com.example.fooddeliveryapp.repostiry.Restaurentrepostiry;
import com.example.fooddeliveryapp.table.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Restaurantservice {

    @Autowired
    Restaurentrepostiry restaurentrepostiry;
    public Restaurant addrestaurant(Restaurant restaurant) {
        return restaurentrepostiry.save(restaurant);
    }
}
