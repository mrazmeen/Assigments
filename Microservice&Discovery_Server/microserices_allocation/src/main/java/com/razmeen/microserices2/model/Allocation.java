package com.razmeen.microserices2.model;

import lombok.Data;

@Data
public class Allocation {

    private Integer ID;
    private Integer employeeID;
    private String start;
    private String end;
    private String projectcode;

}
