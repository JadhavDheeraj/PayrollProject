package com.zensar.payrollmodule.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public final class WelcomeController {

	
	/*
	 * @GetMapping() public String welcome() {
	 * 
	 * final String uri = "http://localhost:9001";
	 * 
	 * RestTemplate template = new RestTemplate();
	 * 
	 * String temp =template.getForObject(uri, String.class);
	 * 
	 * return temp; }
	 */
	 
	
	@GetMapping()
	public String welcome() {
		
		
		
		return "Hello World";
	}
}
