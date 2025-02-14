package com.analytiq.jobportalunnati.core;

import java.io.File;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigServerApplication.class, args);
		 String classpath = System.getProperty("java.class.path");
		   String[] classPathValues = classpath.split(File.pathSeparator);
		   System.out.println(Arrays.toString(classPathValues));
	}

}
