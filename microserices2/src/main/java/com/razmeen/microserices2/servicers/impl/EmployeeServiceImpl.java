package com.razmeen.microserices2.servicers.impl;

import com.razmeen.microserices2.model.Employee;
import com.razmeen.microserices2.repositories.EmployeeRepository;
import com.razmeen.microserices2.servicers.EmployeeServicers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServicers{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAllusers() {

        List<Employee> allusers= employeeRepository.findAll();
        return  allusers;
    }

    @Override
    public String saveEmployees(Employee employeedata) {
        employeeRepository.save(employeedata);
        return "Data Saved";
    }
}
