package com.razmeen.allocation.controller;

import com.razmeen.allocation.model.Allocation;
import com.razmeen.allocation.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Allocation")
public class controller {

    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public List<Allocation> find(@PathVariable Integer id){

        return allocationService.findById(id);
    }

    @RequestMapping(value = "/Save", method = RequestMethod.POST)
    public Allocation Save(@RequestBody Allocation allocation){
return allocationService.Save(allocation);
    }
}
