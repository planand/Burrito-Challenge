package com.generali.burritoorderingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@EnableWebMvc
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "BurritoAPI", version = "1.0", description = "Burrito Information"))
public class BurritoOrderingServiceApplication {

	public static void main(String[] args) {
		 
		SpringApplication.run(BurritoOrderingServiceApplication.class, args);
	}

}
