package com.razmeen.allocation.service;

import com.razmeen.allocation.model.Allocation;

import java.util.List;

public interface AllocationService {
    List<Allocation> findById(Integer id);

    Allocation Save(Allocation allocation);
}
