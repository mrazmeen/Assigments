package com.razmeen.microserices2.controller;


import com.razmeen.microserices2.model.Employee;
import com.razmeen.microserices2.servicers.EmployeeServicers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class controller {

    @Autowired
    private EmployeeServicers employeeServicers;

    @RequestMapping("/all")
    public List<Employee> getData(){

        return employeeServicers.findAllusers();
    }

    @PostMapping("/Save_user")
    public String addUser(@RequestBody Employee employeedata){
        return employeeServicers.saveEmployees(employeedata);



    }
}
