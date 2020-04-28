package com.carsale.userservice.model;

import lombok.Data;

@Data
public class Orders {
    private Integer id;
    private Integer userId;
    private Integer vehicleId;
    private String Description;
}
