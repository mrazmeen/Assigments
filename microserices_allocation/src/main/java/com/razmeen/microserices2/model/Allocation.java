package com.razmeen.microserices2.model;

public class Allocation {

    private Integer ID;
    private Integer employeeID;
    private String start;
    private String end;
    private String projectcode;

    public Allocation() {
    }

    public Allocation(Integer ID, Integer employeeID, String start, String end, String projectcode) {
        this.ID = ID;
        this.employeeID = employeeID;
        this.start = start;
        this.end = end;
        this.projectcode = projectcode;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }
}
