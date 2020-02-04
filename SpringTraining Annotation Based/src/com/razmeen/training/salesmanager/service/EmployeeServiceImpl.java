package com.razmeen.training.salesmanager.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razmeen.training.salesmanager.model.Employee;
import com.razmeen.training.salesmanager.repository.EmployeeRepository;
import com.razmeen.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	
	private EmployeeRepository employeerepository;
	
	public EmployeeServiceImpl() {
		System.out.println("Default Constructor Executed");
		
	}
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeerepository=employeeRepository;
	}

	
	public EmployeeRepository getEmployeerepository() {
		return employeerepository;
	}

	@Autowired
	public void setEmployeerepository(EmployeeRepository employeerepository) {
		System.out.println("Setter injection fired");
		this.employeerepository = employeerepository;
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeerepository.getAllEmployees();
	}
	
}
