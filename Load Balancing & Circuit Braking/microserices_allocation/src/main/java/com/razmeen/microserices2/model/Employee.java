package com.razmeen.microserices2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    @OneToOne(cascade= CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    List<Telephone> telephones;


    @ManyToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinTable(name="employeeorojects",
    joinColumns = @JoinColumn(name = "employeeid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "projectid", referencedColumnName = "id"))
    private List<Project> projects;

    Allocation[] Allocation;


}
