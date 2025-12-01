package com.example.job.company.repository;

import com.example.job.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByLocation(String location);

    @Query("SELECT DISTINCT c FROM Company c LEFT JOIN FETCH c.companyWelfares")
    List<Company> findAllWithWelfares();
}
