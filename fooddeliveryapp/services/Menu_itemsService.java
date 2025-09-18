package com.example.fooddeliveryapp.services;

import com.example.fooddeliveryapp.repostiry.Menu_itemsRepostiry;
import com.example.fooddeliveryapp.table.Menu_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Menu_itemsService {

    @Autowired
    private Menu_itemsRepostiry menuitemrepostiry;
    public List<Menu_items> uploadmenu(List<Menu_items> menuitems){
        return menuitemrepostiry.saveAll(menuitems);
    }

    public List<Menu_items> findByRestauratId(int restauratId){
        return menuitemrepostiry.findByRestaurantId(restauratId);
    }
}
