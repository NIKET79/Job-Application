package com.jobdoor.first.job.app.review.dao;

import com.jobdoor.first.job.app.review.bean.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepostiory extends JpaRepository<Review,Long> {
}
