package com.example.usermanagementserver.controller;

import com.example.usermanagementserver.domain.User;
import com.example.usermanagementserver.repository.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepositoy userRepositoy;

    @PostMapping("/user")
    User newUser (@RequestBody User newUser){
        return userRepositoy.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepositoy.findAll();
    }
}
