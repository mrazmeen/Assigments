package com.razmeen.training.salesmanager.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.razmeen.training.salesmanager.model.Employee;
import com.razmeen.training.salesmanager.repository.EmployeeRepository;
import com.razmeen.training.salesmanager.service.EmployeeService;
import com.razmeen.training.salesmanager.service.EmployeeServiceImpl;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeService employeeRepository=applicationContext.getBean("employeeService",EmployeeService.class);
		
		
		List<Employee> employees=employeeRepository.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeName()+" at "+ employee.getEmployeeLocation());
			
		}
	}

} 
