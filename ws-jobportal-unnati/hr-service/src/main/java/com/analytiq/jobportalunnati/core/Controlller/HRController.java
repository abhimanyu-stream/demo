package com.analytiq.jobportalunnati.core.Controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.analytiq.jobportalunnati.core.entity.HR;
import com.analytiq.jobportalunnati.core.repository.HRRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "hr-service", description = "The hr Service")

@RestController
@RequestMapping("/hr")
public class HRController {
	
	@Autowired
	private HRRepository hrRepository;
	
	
	@Operation(summary = "Get", description = "Any  user can access /hr/ for welcome message in this application") 
	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to HR Service";
	}
	
	
	@Operation(summary = "Post", description = "Any  user can access /hr/save to save a new HR  in this application") 
	@PostMapping("/save")
	public String saveHR(@RequestBody HR hR) {
		
		System.out.println("...Request inside HRController saveHR()");
		hrRepository.save(hR);
		return "hr saved in database";
		
		
	}

}
