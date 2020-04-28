package com.carsale.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname")
    private String firtstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "contactNo")
    private String contactNo;

    @Column(name = "date_joined")
    private Timestamp dateJoined;

    @Column(name = "Status")
    private String Status;//active deactive

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;

    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;

    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    private Orders[] orders;

    public User() {
    }

    public User(Integer id, String firtstName, String lastName, String username, String password, String email, String contactNo, Timestamp dateJoined, String status, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, List roles, Orders[] orders) {
        this.id = id;
        this.firtstName = firtstName;
        this.lastName = lastName;
        this.username=username;
        this.password=password;
        this.email=email;
        this.enabled= enabled;
        this.accountNonExpired=accountNonExpired;
        this.credentialsNonExpired=credentialsNonExpired;
        this.accountNonLocked=accountNonLocked;
        this.contactNo = contactNo;
        this.dateJoined = dateJoined;
        Status = status;
        this.roles=roles;
        this.orders = orders;
    }



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }


}
