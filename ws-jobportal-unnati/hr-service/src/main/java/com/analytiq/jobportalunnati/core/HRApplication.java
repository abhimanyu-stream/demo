package com.analytiq.jobportalunnati.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;




@OpenAPIDefinition(info = @Info(title ="HR API", version = "1.0", description = "HR Service"))
@EnableEurekaClient
@SpringBootApplication
public class HRApplication {

	public static void main(String[] args) {
		SpringApplication.run(HRApplication.class, args);
	}

}
