package com.qualstack.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qualsctack.model.Company;
import com.qualstack.repository.CompanyRepository;

@SpringBootTest(classes = Company.class)
public class CompanyServiceTest {

	@MockBean
	CompanyRepository companyRepository;
	
	@Autowired
	CompanyService companyService;
	
	@Test
	public void testCreatCompany() {
		Company company = new Company();
		company.setName("BANCO X");
		company = companyService.save(company);
		
		assertNotEquals(null, company);
		
	}
	
	@BeforeEach
	public void setUp() {
		BDDMockito.given(companyRepository.save(Mockito.any(Company.class))).willReturn(new Company(1L));
	}
	
}
