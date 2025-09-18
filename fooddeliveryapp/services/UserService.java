package com.example.fooddeliveryapp.services;

import com.example.fooddeliveryapp.repostiry.UserRepostiry;
import com.example.fooddeliveryapp.table.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepostiry userRepostiry;
    public Users adduser(Users user) {
        return userRepostiry.save(user);
    }
}
