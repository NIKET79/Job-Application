package com.jobdoor.first.job.app.job.service.impl;

import com.jobdoor.first.job.app.job.bean.Job;
import com.jobdoor.first.job.app.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    private List<Job>  jobs=new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        for (Job job:jobs){
            if(job.getId()==id){
                return job;
            }
        }
        return null;
    }

    @Override
    public String deleteById(Long id) {
        for(Job job:jobs){
            if(job.getId()==id){
                jobs.remove(id);
                return "SUCCESS" ;
            }
        }
        return "NOT FOUND" ;
    }

    @Override
    public String updateJob(Job job) {
       for(Job avialableJob:jobs){
           if(avialableJob.getId()==job.getId()){
                jobs.remove(avialableJob);
                jobs.add(job);
                return "SUCCESS";
           }

       }
        return "NOT FOUND";
    }


}
