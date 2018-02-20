package com.ateknea.user.userspool.controller;

import com.ateknea.user.userspool.exceptions.InvalidEmail;
import com.ateknea.user.userspool.exceptions.NoSuchUser;
import com.ateknea.user.userspool.exceptions.TooMuchCharacters;
import com.ateknea.user.userspool.model.User;
import com.ateknea.user.userspool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private static int MAX_NAME_FIELD_SIZE = 20;
    private static int MAX_LASTNAME_FIELD_SIZE = 40;
    private static int MAX_EMAIL_FIELD_SIZE = 40;

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> userList() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable long id) throws NoSuchUser {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            throw new NoSuchUser("The desired user is not present: -" + id);
        }
        return user.get();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        checkParameters(user.getName(), user.getLastname(), user.getEmail());
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {
        checkParameters(user.getName(), user.getLastname(), user.getEmail());
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    private void checkParameters(String name, String surname, String email) {
        if (!validNameAndSurname(name, surname)) {
            throw new TooMuchCharacters("Name or Last Name exceed the maximum chars: -"
                    + surname.length() + ", " + name.length());
        }
        if (!validEmail(email)) {
            throw new InvalidEmail("Invalid mail format" + email);
        }
    }

    private boolean validNameAndSurname(String name, String surname) {
        return name.length() <= MAX_NAME_FIELD_SIZE && surname.length() <= MAX_LASTNAME_FIELD_SIZE;
    }

    private boolean validEmail(String email) {
        if (email.length() > MAX_EMAIL_FIELD_SIZE) {
            return false;
        }
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
