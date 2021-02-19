package com.secure.encryption.controller;


import com.secure.encryption.exceptionhandler.ResourceNotFoundException;
import com.secure.encryption.model.user;
import com.secure.encryption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login/{username}/{password}")
    public user userLogin(@PathVariable String username, @PathVariable String password) throws ResourceNotFoundException {
        System.out.println("Calling");
        return userService.userLogin(username, password);

    }

    @GetMapping(value = "/test/{username}/{password}")
    public String test(@PathVariable String username, @PathVariable String password){
        System.out.println("Calling");
        return username+" "+password;
    }
}
