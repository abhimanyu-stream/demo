package com.analytiq.jobportalunnati.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {
	// Among application.properties/ application.yml and bootstrap.yml files always bootstrap.yml is loaded and configuration written here is implemented first. Then application.yml/properties 
	// are loaded and executed
	// Therefore mention Cloud Config Server related things in bootstrap.yml file, which are common configuration for all services.

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
