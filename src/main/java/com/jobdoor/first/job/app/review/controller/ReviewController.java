package com.jobdoor.first.job.app.review.controller;

import com.jobdoor.first.job.app.review.bean.Review;
import com.jobdoor.first.job.app.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping
        public ResponseEntity<String> addReview(@RequestBody Review review){
            reviewService.addReview(review);
            return new ResponseEntity<>("Review Added successfully", HttpStatus.OK);
        }

        @GetMapping
        public List<Review> getAllReview( ){
            return reviewService.findAll();
        }

        @GetMapping("/{id}")
        public Review getById(@PathVariable Long id){
            return reviewService.findById(id);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteById(@PathVariable Long id){
           boolean isDeleted=reviewService.deleteById(id);
            if(isDeleted){
                return new ResponseEntity<>("Review Deleted successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Review Not found", HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id,@RequestBody Review review){
        boolean isUpdated=reviewService.updateByid(id,review);
        if(isUpdated){
            return new ResponseEntity<>("Review Update successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review Not found", HttpStatus.OK);
        }
        }


}
