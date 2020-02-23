package com.razmeen.microserices2.servicers.impl;

import com.razmeen.microserices2.Hystrix.AllocationCommand;
import com.razmeen.microserices2.model.Allocation;
import com.razmeen.microserices2.model.Employee;
//import com.razmeen.microserices2.model.Telephone;
import com.razmeen.microserices2.model.Telephone;
import com.razmeen.microserices2.repositories.EmployeeRepository;
import com.razmeen.microserices2.servicers.EmployeeServicers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServicers{

    @Autowired
    private EmployeeRepository employeeRepository;

    @LoadBalanced
    @Bean
    public RestTemplate getRetRestTemplate(){
        return  new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<Employee> findAllusers() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployees(Employee employeedata) {
        for (Telephone telephone: employeedata.getTelephones()) {
            telephone.setEmployee(employeedata);
        }

        return  employeeRepository.save(employeedata);
    }

    @Override
    public Employee fetchAllAllocations(int employee) {
        Optional<Employee> employee1= employeeRepository.findById(employee);
        HttpHeaders httpHeaders= new HttpHeaders();
        if(employee1.isPresent()){
            Employee employee2=employee1.get();

            AllocationCommand allocationCommand = new AllocationCommand(employee2, httpHeaders, restTemplate);

            employee2.setAllocation(allocationCommand.execute());

            return employee2;
        }
        return null;
    }

    @Override
    public Optional <Employee> findById(int employee) {
        return employeeRepository.findById(employee);
    }
}
