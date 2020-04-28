package com.carsale.userservice.controller;

import com.carsale.userservice.exceptionhandler.ResourceNotFoundException;
import com.carsale.userservice.model.APIResponse;
import com.carsale.userservice.model.User;
import com.carsale.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/email/{email}")
    public List<User> getAllUsersByEmail(@PathVariable String email) {
        return userService.getAllUsersByEmail(email);
    }

    @GetMapping(value = "/user/id/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) throws ResourceNotFoundException {
        return userService.getUserById(userId);
    }

    @PostMapping(value = "/save")
    public User createUser(@RequestBody User user) {
        System.out.println("calling");
        return userService.createUser(user);
    }

    @PutMapping(value = "/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping(value = "/user/{userId}")
    public Map<String, Boolean> deleteUser(@PathVariable Integer userId) throws ResourceNotFoundException {
        return userService.deleteUser(userId);
    }

    @GetMapping(value = "/login/{username}/{password}")
    public APIResponse userLogin(@PathVariable String username, @PathVariable String password) throws ResourceNotFoundException {
        System.out.println("calling");
        return userService.userLogin(username, password);
    }
    @GetMapping(value = "/checktoken/{username}/{accessToken}/{refreshToken}")
    public APIResponse checkAccessToken(@PathVariable String username, @PathVariable String accessToken, @PathVariable String refreshToken) {
        return userService.checkAccessToken(username, accessToken, refreshToken);
    }
}
