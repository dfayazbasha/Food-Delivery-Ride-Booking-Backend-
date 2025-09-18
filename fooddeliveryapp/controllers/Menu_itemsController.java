package com.example.fooddeliveryapp.controllers;

import com.example.fooddeliveryapp.services.Menu_itemsService;
import com.example.fooddeliveryapp.table.Menu_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Menu")
public class Menu_itemsController {

    @Autowired
    private  Menu_itemsService menuitemsService;

    @PostMapping ("/uploadmenu")
    public List<Menu_items> uploadmenu(@RequestBody List<Menu_items> menuitems){
        return menuitemsService.uploadmenu(menuitems);
    }

    @GetMapping("/{id}")
    public List<Menu_items> findByRestaurantId(@PathVariable int id){
        return menuitemsService.findByRestauratId(id);
    }

}
