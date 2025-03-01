package com.innoventes.test.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innoventes.test.app.entity.Company;

import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Long> {


    // Add an API
    // added by Lijo Joseph
    Optional<Object> findByCompanyCode(String companyCode);
}