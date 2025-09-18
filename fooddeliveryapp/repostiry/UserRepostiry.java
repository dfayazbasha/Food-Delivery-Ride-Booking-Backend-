package com.example.fooddeliveryapp.repostiry;

import com.example.fooddeliveryapp.table.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostiry extends JpaRepository<Users,Integer> {
}
