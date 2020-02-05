package com.razmeen.training.salesmanager.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.razmeen.training.salesmanager.model.Employee;
import com.razmeen.training.salesmanager.repository.EmployeeRepository;
import com.razmeen.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;


public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepository employeerepository;

	public EmployeeRepository getEmployeerepository() {
		return employeerepository;
	}

	public void setEmployeerepository(EmployeeRepository employeerepository) {
		this.employeerepository = employeerepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeerepository.getAllEmployees();
	}

	
}
