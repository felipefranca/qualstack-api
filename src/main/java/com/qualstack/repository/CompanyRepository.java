package com.qualstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qualstack.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
