package com.razmeen.training.salesmanager.service;


import java.util.List;

import com.razmeen.training.salesmanager.model.Employee;
import com.razmeen.training.salesmanager.repository.EmployeeRepository;
import com.razmeen.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeerepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeerepository=employeeRepository;
	}

	
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
