package com.training.memento;

public class CarParts {

    String name;

    public CarParts(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarParts{" +
                "name='" + name + '\'' +
                '}';
    }
}
