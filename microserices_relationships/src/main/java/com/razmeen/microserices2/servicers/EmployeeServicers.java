package com.razmeen.microserices2.servicers;

import com.razmeen.microserices2.model.Employee;

import java.util.List;

public interface EmployeeServicers {

    List<Employee> findAllusers();

     Employee saveEmployees(Employee employeedata);

}
