package com.razmeen.training.salesmanager.main;

import java.util.List;

import com.razmeen.training.salesmanager.model.Employee;
import com.razmeen.training.salesmanager.repository.EmployeeRepository;
import com.razmeen.training.salesmanager.service.EmployeeService;
import com.razmeen.training.salesmanager.service.EmployeeServiceImpl;

public class Application {

	public static void main(String[] args) {
		
		EmployeeService emp= new EmployeeServiceImpl();
		
		List<Employee> employees=emp.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName()+" at "+ employee.getEmployeeLocation());
			
		}
	}

}
