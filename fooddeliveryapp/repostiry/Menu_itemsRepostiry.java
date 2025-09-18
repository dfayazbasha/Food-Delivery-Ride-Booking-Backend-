package com.example.fooddeliveryapp.repostiry;

import com.example.fooddeliveryapp.table.Menu_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Menu_itemsRepostiry extends JpaRepository<Menu_items, Integer> {

    List<Menu_items> findByRestaurantId(int restaurantId);
}
