package com.razmeen.microserices2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "telephone")
@Data
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ContactNumber;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Employee employee;


}
