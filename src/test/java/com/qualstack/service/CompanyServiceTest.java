package com.qualstack.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qualstack.model.Company;

import lombok.Getter;
import lombok.Setter;


@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
public class CompanyServiceTest {

	private static final String URL = "/company";
	private static final String NAME = "TESTE";
	private static final Long ID = 1L;

	@Autowired
	MockMvc mvc;

	@MockBean
	CompanyService companyService;

	@Test
	public void testCreateCompany() throws JsonProcessingException, Exception {

		BDDMockito.given(companyService.save(Mockito.any(Company.class))).willReturn(getMockCompany());

		ObjectMapper mapper = new ObjectMapper();
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(mapper.writeValueAsString(getMockCompany()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.id").value(ID))
		.andExpect(jsonPath("$.name").value(NAME));

	}

	@Getter @Setter
	class CompanyDTO {
		String name;
		Long id;
		
	}
	
	private Company getMockCompany() {
		Company company = new Company();
		company.setId(ID);
		company.setName(NAME);
		return company;
	}
}
