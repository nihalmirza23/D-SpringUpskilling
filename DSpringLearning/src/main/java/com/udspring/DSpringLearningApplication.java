package com.udspring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Rest Api Documentation",
				description = "Spring Boot REST API Documentation",
				version ="v1.0",
				contact = @Contact(
						name = "Nihal",
						email ="nihalmirza23@gmail.com",
						url="http://www.nihal.net"
						),
				license = @License(
					name = "Apache 2.0",
					url="http://www.nihal.net"
						
						)
				
						),
				externalDocs = @ExternalDocumentation(
						description = "Spring Boot user Management Documentation",
						url="http://www.nihal.net"
						)
		
		)
public class DSpringLearningApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new  ModelMapper();
	}
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(DSpringLearningApplication.class, args);
	}
	
	
	

}
