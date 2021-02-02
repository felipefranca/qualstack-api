package com.qualstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qualsctack.model.Company;
import com.qualstack.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public Company save(Company company) {

		return companyRepository.save(company);

	}

	public List<Company> listAll(){
		return companyRepository.findAll();
	}
	
}
