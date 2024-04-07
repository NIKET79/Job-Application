package com.jobdoor.first.job.app.company.service.impl;

import com.jobdoor.first.job.app.company.bean.Company;
import com.jobdoor.first.job.app.company.dao.CompanyRepository;
import com.jobdoor.first.job.app.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return    companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateById(Long id,Company updatedCompany) {
        Optional<Company>  companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company= companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setType(updatedCompany.getType());
            company.setEmployeesRange(updatedCompany.getEmployeesRange());
            company.setLocation(updatedCompany.getLocation());
            companyRepository.save(company);
            return  true;
        }else{
            return false;
        }
    }
}
