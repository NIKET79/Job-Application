package com.jobdoor.first.job.app.review.controller;

import com.jobdoor.first.job.app.review.bean.Review;
import com.jobdoor.first.job.app.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/reviews")
        public ResponseEntity<String> addReview(@PathVariable Long  companyId, @RequestBody Review review){
            boolean isReviewAdded=reviewService.addReview(companyId,review);
            if(isReviewAdded){
                return new ResponseEntity<>("Review Added successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
            }

        }

        @GetMapping("/reviews")
        public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId ){
            List<Review>  reviews=reviewService.findAll(companyId);
            return new ResponseEntity<>(reviews,HttpStatus.OK);
        }

        @GetMapping("/reviews/{reviewId}")
        public Review getById(@PathVariable Long reviewId,@PathVariable Long companyId){
                return reviewService.findById(reviewId,companyId);
        }

        @DeleteMapping("/reviews/{reviewId}")
        public ResponseEntity<String> deleteById(@PathVariable Long reviewId,@PathVariable Long companyId){
           boolean isDeleted=reviewService.deleteById(reviewId,companyId);
            if(isDeleted){
                return new ResponseEntity<>("Review Deleted successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Review Not found", HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateById(@PathVariable Long reviewId,@PathVariable Long companyId,@RequestBody Review review){
        boolean isUpdated=reviewService.updateByid(reviewId,companyId,review);
        if(isUpdated){
            return new ResponseEntity<>("Review Update successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review Not found", HttpStatus.OK);
        }
        }


}
