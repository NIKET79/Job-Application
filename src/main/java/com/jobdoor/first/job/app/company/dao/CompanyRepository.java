package com.jobdoor.first.job.app.company.dao;

import com.jobdoor.first.job.app.company.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
