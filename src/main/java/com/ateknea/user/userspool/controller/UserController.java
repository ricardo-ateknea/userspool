package com.ateknea.user.userspool.controller;

import com.ateknea.user.userspool.model.User;
import com.ateknea.user.userspool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public List<User> greeting(@RequestParam(value="name", defaultValue="") String name) {
        return userRepository.findAll();
    }
}
