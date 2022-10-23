package com.poc.dataService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@EnableWebMvc
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "DataServiceAPI", version = "1.0", description = "Data Information"))
public class DataServiceApplication {

	public static void main(String[] args) {
		 
		SpringApplication.run(DataServiceApplication.class, args);
	}

}
