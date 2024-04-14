package com.jobdoor.first.job.app.review.service;

import com.jobdoor.first.job.app.review.bean.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
   public boolean addReview(Long  companyId,Review review);

    public   List<Review> findAll(Long companyId);

   public  Review findById(Long reviewId,Long companyId);

  public  boolean deleteById(Long reviewId,Long companyId);

    public   boolean updateByid(Long id, Long companyId,Review review);
}
