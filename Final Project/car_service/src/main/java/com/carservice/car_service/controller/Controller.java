package com.carservice.car_service.controller;


import com.carservice.car_service.model.APIResponse;
import com.carservice.car_service.model.CarModel;
import com.carservice.car_service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/car")
public class Controller {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/cars")
    public List<CarModel> getAllCars() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public APIResponse save(@RequestBody CarModel car){
        System.out.println("sshshshshshsshshshhssh");
        return  carService.saveCar(car);
    }

}
