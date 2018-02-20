package com.ateknea.user.userspool.service;

import com.ateknea.user.userspool.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findById(Long id);
    User findByName(String name);
    User saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
}
