package com.razmeen.microservices.controller;

import com.razmeen.microservices.model.Employees;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {

   public Employees employees;

    @RequestMapping("employees")
    public List<Employees> getAllEmployees(){
        return Employees.getAllEmployees();
    }
}
