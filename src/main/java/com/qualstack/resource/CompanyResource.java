package com.qualstack.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qualstack.model.Company;
import com.qualstack.repository.CompanyRepository;

@RequestMapping("/company")
@RestController
public class CompanyResource extends BaseResource<CompanyRepository, Company>{
	

}
