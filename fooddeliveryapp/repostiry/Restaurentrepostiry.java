package com.example.fooddeliveryapp.repostiry;

import com.example.fooddeliveryapp.table.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Restaurentrepostiry extends JpaRepository<Restaurant, Long> {
}
