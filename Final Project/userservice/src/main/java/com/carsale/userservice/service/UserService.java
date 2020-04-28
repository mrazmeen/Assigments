package com.carsale.userservice.service;

import com.carsale.userservice.exceptionhandler.ResourceNotFoundException;
import com.carsale.userservice.model.APIResponse;
import com.carsale.userservice.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;


public interface UserService {


    List<User> getAllUsers();
    List<User> getAllUsersByEmail(String email);
    User getUserByUsername(String username);
    ResponseEntity<User> getUserById(Integer userId) throws ResourceNotFoundException;

    User createUser(User user);
    ResponseEntity<User> updateUser(Integer userId, User user);
    Map<String, Boolean> deleteUser(Integer userId) throws ResourceNotFoundException;

    APIResponse userLogin(String email, String password) throws ResourceNotFoundException;

    APIResponse refreshAccessToken(String refreshToken);
    APIResponse checkAccessToken(String username, String accessToken, String refreshToken);
}
