package com.jobdoor.first.job.app.review.service.impl;

import com.jobdoor.first.job.app.company.bean.Company;
import com.jobdoor.first.job.app.company.service.CompanyService;
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
    @Autowired
    private CompanyService companyService;

    @Override
    public boolean addReview(Long companyId,Review review) {
        Company company=companyService.findById(companyId);
        if(null!=company){
            review.setCompany(company);
            reviewRepostiory.save(review);
            return  true;
        }
        else{
            return  false;
        }


    }

    @Override
    public List<Review> findAll(Long companyId) {
        return reviewRepostiory.findByCompanyId(companyId);
    }

    @Override
    public Review findById(Long reviewId,Long companyId) {
        List<Review> companies = reviewRepostiory.findByCompanyId(companyId);
        return companies.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean deleteById(Long reviewId,Long companyId) {

        if(null!=companyService.findById(companyId) && reviewRepostiory.existsById(reviewId) ){
            Review review=reviewRepostiory.findById(reviewId).orElse(null);
            Company company=review.getCompany();
            company.getReviews().remove(review);
            companyService.updateById(companyId,company);
            reviewRepostiory.deleteById(reviewId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateByid(Long id, Long companyId,Review updatedReview) {
        Company company=companyService.findById(companyId);
        Optional<Review> reviewOptional=reviewRepostiory.findById(id);
        if(reviewOptional.isPresent() && company!=null){
            Review review=reviewOptional.get();
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompany(company);
            reviewRepostiory.save(review);
            return true;
        }
        else{
            return false;
        }

    }
}
