package com.jobdoor.first.job.app.job.controller;

import com.jobdoor.first.job.app.job.bean.Job;
import com.jobdoor.first.job.app.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController()
public class JobContoller {
        @Autowired
        private JobService jobService;
        @GetMapping("/jobs")
        public List<Job> findAll(){
               return jobService.findAll();
        }

        @GetMapping ("/job/{id}")
        public Job findByID(@PathVariable("id") Long id){
                return jobService.findById(id);
        }

        @PostMapping("/addjob")
        public String addJob(@RequestBody Job job){
                jobService.createJob(job);
                return  "Job added Successfully";
        }

}
