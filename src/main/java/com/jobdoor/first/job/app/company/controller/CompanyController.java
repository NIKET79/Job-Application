package com.jobdoor.first.job.app.company.controller;

import com.jobdoor.first.job.app.company.bean.Company;
import com.jobdoor.first.job.app.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return  new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Company> > findAll(){
      return   new ResponseEntity<>( companyService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Company> findById(@PathVariable Long id){
        return  new ResponseEntity<>(companyService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean isDeleted=companyService.deleteById(id);
        if(isDeleted){
            return  new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id,@RequestBody Company company){
        boolean isUpdated=companyService.updateById(id,company);
        if(isUpdated){
            return  new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }


}
