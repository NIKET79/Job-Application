package com.jobdoor.first.job.app.company.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobdoor.first.job.app.job.bean.Job;
import com.jobdoor.first.job.app.review.bean.Review;
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

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;


    public Company() {
    }

    public Company(String name, List<String> location, String description, List<Job> jobs, List<Review> reviews) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.jobs = jobs;
        this.reviews = reviews;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
