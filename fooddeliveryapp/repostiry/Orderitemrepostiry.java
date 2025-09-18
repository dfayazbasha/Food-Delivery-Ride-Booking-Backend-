package com.example.fooddeliveryapp.repostiry;

import com.example.fooddeliveryapp.table.Orderitems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Orderitemrepostiry extends JpaRepository<Orderitems,Long> {
}
