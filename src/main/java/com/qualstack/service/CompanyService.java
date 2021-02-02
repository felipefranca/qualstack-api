package com.qualstack.service;

import java.util.List;

import com.qualsctack.model.Company;


public interface CompanyService {
	public Company save(Company company);
	public List<Company> listAll();
}
