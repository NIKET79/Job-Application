package com.jobdoor.first.job.app.company.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company_table")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<String> location;

    private String description;

    private String type;
    private String employeesRange;


    public Company() {
    }

    public Company(String name, List<String> location, String type, String employeesRange) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.employeesRange = employeesRange;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmployeesRange() {
        return employeesRange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmployeesRange(String employeesRange) {
        this.employeesRange = employeesRange;
    }
}
