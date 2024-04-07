package com.jobdoor.first.job.app.job.service;

import com.jobdoor.first.job.app.job.bean.Job;

import java.util.List;

public interface JobService {
        public List<Job> findAll();

        public void createJob(Job job);

        public Job findById(Long id);

        public String deleteById(Long id);

        public String updateJob(Long id,Job job);
}
