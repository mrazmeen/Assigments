package com.razmeen.microserices2.repositories;

import com.razmeen.microserices2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
