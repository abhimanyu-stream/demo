package com.analytiq.jobportalunnati.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "notification-service", description = "The notification Service")
@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	
	@Operation(summary = "Get", description = "Any  user can access /notification/ for welcome message in this application") 
	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to notification Service";
	}

}
