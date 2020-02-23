package com.razmeen.microserices2.servicers;

import com.razmeen.microserices2.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServicers {

    List<Employee> findAllusers();

     Employee saveEmployees(Employee employeedata);

    Employee fetchAllAllocations(int employee);

    Optional<Employee> findById(int employee);
}
