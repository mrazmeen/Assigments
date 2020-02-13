package com.razmeen.allocation.repository;

import com.razmeen.allocation.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
}
