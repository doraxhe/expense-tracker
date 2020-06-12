package com.dtcc.expensetracker.controller;

import com.dtcc.expensetracker.model.User;
import com.dtcc.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/user") // PostMapping sends data to db
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
