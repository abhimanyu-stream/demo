package com.analytiq.jobportalunnati.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
public class ApplicantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicantServiceApplication.class, args);
	}
/**
INSERT INTO role VALUES(1,'ROLE_ADMIN');
INSERT INTO role VALUES(2,'ROLE_USER');
INSERT INTO role VALUES(3,'ROLE_MODERATOR');

write sql file and create a bit file and executes at application startuptime
drop db first then create
create static block to insert these values in role table at application startuptime onetimeonly
*/
}
