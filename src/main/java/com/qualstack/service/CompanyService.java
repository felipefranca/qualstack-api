package com.qualstack.service;

import java.util.List;

import com.qualstack.model.Company;

public interface CompanyService {
	Company save(Company company);
	List<Company> listAll();
}
