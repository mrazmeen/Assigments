package com.razmeen.microservices.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class Employees {

    private String name;
    private String Age;
    private String location;


    public Employees(String name, String age, String location){
        this.Age=age;
        this.name=name;
        this.location=location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public static List<Employees> getAllEmployees(){
        List<Employees> employees= new ArrayList<>();
        Employees emp1= new Employees("Ruzaik","23","Kurunagala");
        Employees emp2= new Employees("Hasitha","24","Kiribathgoda");
        Employees emp3= new Employees("Alfar","26","Baticalo");

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;

    }
}
