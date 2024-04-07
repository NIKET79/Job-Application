package com.jobdoor.first.job.app.company.service;

import com.jobdoor.first.job.app.company.bean.Company;

import java.util.List;

public interface CompanyService {
    public void addCompany(Company company);

   public  List<Company> findAll();

   public  Company findById(Long id);

   public  boolean deleteById(Long id);

   public  boolean updateById(Long id,Company updatedCompany);
}
