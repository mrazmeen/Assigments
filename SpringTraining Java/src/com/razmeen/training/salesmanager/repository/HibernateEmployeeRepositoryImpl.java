package com.razmeen.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import com.razmeen.training.salesmanager.model.Employee;

public class HibernateEmployeeRepositoryImpl implements EmployeeRepository{
	

	
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee> employees= new ArrayList<Employee>();
		Employee employee= new Employee();
		employee.setEmployeeLocation("Kandy");
		employee.setEmployeeName("Razmeen");
		employees.add(employee);
		return employees;
	}

}
