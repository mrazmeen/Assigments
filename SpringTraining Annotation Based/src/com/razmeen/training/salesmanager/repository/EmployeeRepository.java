package com.razmeen.training.salesmanager.repository;

import java.util.List;

import com.razmeen.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();

}