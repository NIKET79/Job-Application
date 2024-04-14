package com.jobdoor.first.job.app.job.bean;
import com.jobdoor.first.job.app.company.bean.Company;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String title;
        private String  descritption;
        private String minSalary;
        private String maxSalary;
        private String location;
        @ManyToOne
        private Company company;
    public Job() {
    }

    public Job(long id, String title, String descritption, String minSalary, String maxSalary, String location, Company company) {
        this.id = id;
        this.title = title;
        this.descritption = descritption;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
        this.company = company;
    }

    public Job(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
