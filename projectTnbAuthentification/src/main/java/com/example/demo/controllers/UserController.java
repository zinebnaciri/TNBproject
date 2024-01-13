package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserRegistrationRequest;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;  // You need to create a UserService class for user registration

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationRequest request) {
        userService.registerUser(request);
        return "User registered successfully";
    }
}