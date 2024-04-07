package com.jobdoor.first.job.app.job.service.impl;

import com.jobdoor.first.job.app.job.Dao.JobRepository;
import com.jobdoor.first.job.app.job.bean.Job;
import com.jobdoor.first.job.app.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        return  jobRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteById(Long id) {
        try{
            jobRepository.deleteById(id);
            return "SUCCESS";
        }catch (Exception e){
            return  "NOT FOUND";
        }

    }

    @Override
    public String updateJob(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()){
              Job avialableJob= jobOptional.get();
                avialableJob.setTitle(job.getTitle());
                avialableJob.setDescritption(job.getDescritption());
                avialableJob.setMinSalary(job.getMinSalary());
                avialableJob.setMaxSalary(job.getMaxSalary());
                avialableJob.setLocation(job.getLocation());
                jobRepository.save(avialableJob);
                return "SUCCESS";
            }
        return "NOT FOUND";
    }
    }


