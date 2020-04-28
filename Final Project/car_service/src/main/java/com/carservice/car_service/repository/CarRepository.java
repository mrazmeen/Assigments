package com.carservice.car_service.repository;

import com.carservice.car_service.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarModel,Integer> {

    List<CarModel> findCarsByMake(String make);
}
