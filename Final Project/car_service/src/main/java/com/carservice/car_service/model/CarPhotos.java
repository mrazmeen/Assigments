package com.carservice.car_service.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "car_photos")
public class CarPhotos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "path")
    private String path;
    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CarModel carModel;

    public CarPhotos() {
    }

    public CarPhotos(Integer id, String path, String image, CarModel carModel) {
        Id = id;
        this.path = path;
        this.image = image;
        this.carModel = carModel;
    }
}
