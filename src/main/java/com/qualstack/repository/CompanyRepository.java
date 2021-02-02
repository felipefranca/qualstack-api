package com.qualstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qualsctack.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
