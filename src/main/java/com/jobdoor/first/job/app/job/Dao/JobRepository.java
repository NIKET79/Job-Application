package com.jobdoor.first.job.app.job.Dao;

import com.jobdoor.first.job.app.job.bean.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository  extends JpaRepository<Job,Long> {
}
