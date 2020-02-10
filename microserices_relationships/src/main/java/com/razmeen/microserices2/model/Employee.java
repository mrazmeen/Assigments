package com.razmeen.microserices2.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "f_name")
    private String firstName;
    @Column(name = "l_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade= CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    List<Telephone> telephones;

    public Employee() {
    }
    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }





    public Employee(String firstName, String lastName, Integer age, String email,Address address,List<Telephone> telephones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.address=address;
        this.telephones=telephones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Employee> getAllEmployees(){
        List<Employee> employees= new ArrayList<>();
        List<Telephone> telephones= new ArrayList<>();
        telephones.add(new Telephone("0750914114"));
        employees.add(new Employee("Mohamed","Zaky",26,"razmeen@gmail.com",new Address("Kandy"),telephones));
//        employees.add(new Employee("Mohamed","Alfer",26,"Alfer@gmail.com",new Address("Baticalo")));
//        employees.add(new Employee("Mohamed","Ruzaik",23,"Ruzaik@gmail.com",new Address("Kurunagala")));
//        employees.add(new Employee("Hasitha","Jayawardhana",24,"Hasitha@gmail.com",new Address("Kiribathgoda")));
        return  employees;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
