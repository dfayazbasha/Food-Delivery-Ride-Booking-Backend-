package com.example.fooddeliveryapp.controllers;

import com.example.fooddeliveryapp.services.UserService;
import com.example.fooddeliveryapp.table.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/newuser")
    public Users adduser(@RequestBody Users user) {
        return userService.adduser(user);
    }
}
