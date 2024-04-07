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

        @DeleteMapping("deletejob/{id}")
        public ResponseEntity<String> deleteJobById(@PathVariable Long id){
                String result=jobService.deleteById(id);;
                if (result == "SUCCESS") {
                return  new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
                }
                else{
                        return  new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
                }
        }

//        @PutMapping("updatejob/{id}")
        @RequestMapping(value = "updatejob/{id}",method = RequestMethod.PUT)
        public  ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody  Job  job){
                String result= jobService.updateJob(id,job);
                if (result == "SUCCESS") {
                        return  new ResponseEntity<>("Updated successfully",HttpStatus.OK);
                }
                else{
                        return  new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
                }
        }
}
