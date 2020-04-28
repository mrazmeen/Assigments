package com.carservice.car_service.service;

import com.carservice.car_service.exceptionhandler.ResourceNotFoundException;
import com.carservice.car_service.model.*;
import com.carservice.car_service.repository.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Optional<CarModel> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<CarModel> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<CarModel> getCarsByBrandName(String make) {
        if(make.equals("all")){
            return getAllCars();
        }else{
            return carRepository.findCarsByMake(make);
        }
    }

    @Override
    public List<CarModel> getCarsByName(String carName) {
        return null;
    }

    @Override
    public ResponseEntity<CarModel> getCarsById(Integer carId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<CarModel> getCarsByTypeName(String typeName) {
        return null;
    }

    @Override
    public CarModel getCarsBYModelName(String modelName) {
        return null;
    }

    @Override
    public APIResponse saveCar(CarModel car) {

        for (CarPhotos carPhotos : car.getCarPhotos()) {
            carPhotos.setCarModel(car);
        }


//        return carRepository.save(car);
        CarModel car1 = carRepository.save(car);
        if (car1 != null) {
            return new APIResponse(200, "Successful!");
        } else {
            return new APIResponse(404, "Unsuccessful!");
        }
    }

    @Override
    public APIResponse updateCar(CarModel car) {
        return null;
    }

    @Override
    public APIResponse deleteCar(Integer carId) {
        return null;
    }


}
