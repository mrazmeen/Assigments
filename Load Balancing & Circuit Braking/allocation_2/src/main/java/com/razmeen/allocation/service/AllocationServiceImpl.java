package com.razmeen.allocation.service;

import com.razmeen.allocation.model.Allocation;
import com.razmeen.allocation.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public List<Allocation> findById(Integer id) {
        System.err.println("Calling AllocationServiceTwo");
        Allocation allocation= new Allocation();
        allocation.setEmployeeID(id);
        Example<Allocation> employeeexample= Example.of(allocation);
        return allocationRepository.findAll(employeeexample);
    }

    @Override
    public Allocation Save(Allocation allocation) {
        return allocationRepository.save(allocation);
    }
}
