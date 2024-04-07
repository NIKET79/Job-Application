package com.jobdoor.first.job.app.review.service;

import com.jobdoor.first.job.app.review.bean.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
   public void addReview(Review review);

    public   List<Review> findAll();

   public  Review findById(Long id);

  public  boolean deleteById(Long id);

    public   boolean updateByid(Long id, Review review);
}
