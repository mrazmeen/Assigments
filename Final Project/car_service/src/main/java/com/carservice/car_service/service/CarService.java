package com.carservice.car_service.service;

import com.carservice.car_service.exceptionhandler.ResourceNotFoundException;
import com.carservice.car_service.model.APIResponse;
import com.carservice.car_service.model.CarModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<CarModel> findById(Integer id);
    List<CarModel> getAllCars();
    List<CarModel> getCarsByBrandName(String make);
    List<CarModel> getCarsByName(String carName);
    ResponseEntity<CarModel> getCarsById(Integer carId) throws ResourceNotFoundException;
    List<CarModel> getCarsByTypeName(String typeName);
    CarModel getCarsBYModelName(String modelName);

    APIResponse saveCar(CarModel car);
    APIResponse updateCar(CarModel car);
    APIResponse deleteCar(Integer carId);
}
