package com.example.fooddeliveryapp.controllers;

import com.example.fooddeliveryapp.services.Restaurantservice;
import com.example.fooddeliveryapp.table.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Restaurant")
public class Restaurentcontroller {


    @Autowired
    private Restaurantservice restaurantservice;
    @PostMapping("/restaurentdetails")
    public Restaurant restaurantdetails(@RequestBody Restaurant restaurant) {
        return restaurantservice.addrestaurant(restaurant);
    }

}
