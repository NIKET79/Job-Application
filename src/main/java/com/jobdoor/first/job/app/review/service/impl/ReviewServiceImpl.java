package com.jobdoor.first.job.app.review.service.impl;

import com.jobdoor.first.job.app.review.bean.Review;
import com.jobdoor.first.job.app.review.dao.ReviewRepostiory;
import com.jobdoor.first.job.app.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {


    @Autowired
   private ReviewRepostiory reviewRepostiory;

    @Override
    public void addReview(Review review) {
        reviewRepostiory.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepostiory.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepostiory.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Review> reviewOptional=reviewRepostiory.findById(id);
        if(reviewOptional.isPresent()){
            reviewRepostiory.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateByid(Long id, Review updatedReview) {
        Optional<Review> reviewOptional=reviewRepostiory.findById(id);
        if(reviewOptional.isPresent()){
            Review review=reviewOptional.get();
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            reviewRepostiory.save(review);
            return true;
        }
        else{
            return false;
        }

    }
}
