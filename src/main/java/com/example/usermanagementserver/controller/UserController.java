package com.example.usermanagementserver.controller;

import com.example.usermanagementserver.domain.User;
import com.example.usermanagementserver.exception.UserNotFoundException;
import com.example.usermanagementserver.repository.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepositoy.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepositoy.findById(id)
                .map(user -> {
                    user.setUserName(newUser.getUserName());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepositoy.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if (!userRepositoy.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepositoy.deleteById(id);
        return "User with id " + id + " has been deleted.";
    }
}
