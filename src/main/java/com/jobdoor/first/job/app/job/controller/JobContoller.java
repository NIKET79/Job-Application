package com.jobdoor.first.job.app.job.controller;

import com.jobdoor.first.job.app.job.bean.Job;
import com.jobdoor.first.job.app.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController()
public class JobContoller {
        @Autowired
        private JobService jobService;
        @GetMapping("/jobs")
        public ResponseEntity< List<Job>> findAll(){
               return ResponseEntity.ok(jobService.findAll());
        }

        @GetMapping ("/job/{id}")
        public ResponseEntity<Job> findByID(@PathVariable("id") Long id){
                Job job=jobService.findById(id);
                if(null!=job) return new ResponseEntity<Job>(job,HttpStatus.OK);
                return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND);
        }

        @PostMapping("/addjob")
        public  ResponseEntity<String> addJob(@RequestBody Job job){
                jobService.createJob(job);
                return new ResponseEntity<>( "Job added Successfully",HttpStatus.OK);
        }

}
