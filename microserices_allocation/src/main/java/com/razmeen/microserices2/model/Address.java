package com.razmeen.microserices2.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Address() {
    }

    public Address(String cirty) {
        this.cirty = cirty;
    }

    private String cirty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCirty() {
        return cirty;
    }

    public void setCirty(String cirty) {
        this.cirty = cirty;
    }
}
