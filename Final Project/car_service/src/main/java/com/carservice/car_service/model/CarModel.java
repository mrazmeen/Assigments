package com.carservice.car_service.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "car_model")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name="model_name")
    private String modelName;
    @Column(name="car_type")
    private String type;
    @Column(name="car_make")
    private String make;
    @Column(name="car_mileage")
    private String mileage;
    @Column(name="car_condition")
    private String condition;
    @Column(name="car_exterior_color")
    private String exteriorColor;
    @Column(name="car_interior_color")
    private String interiorColor;
    @Column(name="car_interior_material")
    private String interiorMaterial;
    @Column(name="car_general_information")
    private String generalInformation;
    @Column(name="car_overview")
    private String overview;
    @Column(name = "car_price")
    private Float price;
    @Column(name="car_drivetrain")
    private String drivetrain;
    @Column(name = "car_engine_type")
    private String engineType;
    @Column(name = "car_displacement")//(liters/cubic inches)
    private String displacement;
    @Column(name = "car_horsepower")
    private String horsepower;
    @Column(name = "car_torque ")
    private String torque ;
    @Column(name = "car_seating_capacity")
    private String SeatingCapacity ;
    @Column(name = "car_brake_type")
    private String brakeType;
    @Column(name="car_transmission")
    private String transmission;

    @OneToMany(mappedBy = "carModel",cascade = CascadeType.ALL)
    List<CarPhotos> carPhotos;


    public CarModel() {
    }


    public CarModel(Integer id,String modelName, String type, String make, String mileage, String condition, String exteriorColor, String interiorColor, String interiorMaterial, String generalInformation, String overview, Float price, String drivetrain, String engineType, String displacement, String horsepower, String torque, String seatingCapacity, String brakeType, String transmission, List<CarPhotos> carPhotos) {
        Id = id;
        this.modelName = modelName;
        this.type = type;
        this.make = make;
        this.mileage = mileage;
        this.condition = condition;
        this.exteriorColor = exteriorColor;
        this.interiorColor = interiorColor;
        this.interiorMaterial = interiorMaterial;
        this.generalInformation = generalInformation;
        this.overview = overview;
        this.price = price;
        this.drivetrain = drivetrain;
        this.engineType = engineType;
        this.displacement = displacement;
        this.horsepower = horsepower;
        this.torque = torque;
        this.SeatingCapacity = seatingCapacity;
        this.brakeType = brakeType;
        this.transmission = transmission;
        this.carPhotos = carPhotos;
    }
}
