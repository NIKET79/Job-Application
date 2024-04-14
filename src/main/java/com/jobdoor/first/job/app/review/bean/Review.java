package com.jobdoor.first.job.app.review.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobdoor.first.job.app.company.bean.Company;
import jakarta.persistence.*;

@Entity
@Table(name = "review_table")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double  rating;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    @JsonIgnore
    @ManyToOne
    private Company company;
    public Review() {
    }

    public Review(Double rating, String title, String description, Company company) {
        this.rating = rating;
        this.title = title;
        this.description = description;
        this.company = company;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
