package com.jobdoor.first.job.app.review.dao;

import com.jobdoor.first.job.app.review.bean.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepostiory extends JpaRepository<Review,Long> {

    List<Review> findByCompanyId(Long companyIds);
}
