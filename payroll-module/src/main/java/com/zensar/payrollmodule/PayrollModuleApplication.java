package com.zensar.payrollmodule;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class PayrollModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollModuleApplication.class, args);
		
		System.out.println(LocalDate.now());
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
