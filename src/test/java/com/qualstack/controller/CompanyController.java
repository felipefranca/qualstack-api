package com.qualstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qualsctack.model.Company;
import com.qualstack.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public List<Company> listAll(){
		return companyService.listAll();
	}
	
	@PostMapping
	public ResponseEntity<Company> save(@RequestParam Company company) {
		
		companyService.save(company);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(company);
		
	}
	
}
