package com.qualstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@ComponentScan({ "com.qualstack.*" })
@ComponentScan({ "com.qualstack.service" })
@EntityScan("com.qualstack.model")
@EnableJpaRepositories("com.qualstack.repository")  
exclude = { DataSourceAutoConfiguration.class } 
*/
@SpringBootApplication
public class QualstackApiStsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualstackApiStsApplication.class, args);
	}

}
