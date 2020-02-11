package com.razmeen.microserices2.controller;


import com.razmeen.microserices2.model.Employee;
import com.razmeen.microserices2.servicers.EmployeeServicers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class controller {

    @Autowired
    private EmployeeServicers employeeServicers;

    @RequestMapping(value = "/employeeall")
    public List<Employee> getData(){

//        return employeeServicers.findAllusers();
      return  employeeServicers.findAllusers();
    }

   @RequestMapping(value = "/SaveEmployee", method = RequestMethod.POST)
    public Employee addUser(@RequestBody Employee employeedata){
        return employeeServicers.saveEmployees(employeedata);
    }
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public Optional <Employee> findByID(@PathVariable int id){
        return employeeServicers.findById(id);

    }

    @RequestMapping(value = "/Fetch/{employee}")
    public Employee fetch(@PathVariable int employee){
      return   employeeServicers.fetchAllAllocations(employee);
    }
}
