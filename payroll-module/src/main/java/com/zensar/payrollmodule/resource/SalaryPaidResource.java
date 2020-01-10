package com.zensar.payrollmodule.resource;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zensar.payrollmodule.entity.JSONData;
import com.zensar.payrollmodule.entity.SalaryPaid;
import com.zensar.payrollmodule.entity.SalaryPaidEntity;
import com.zensar.payrollmodule.service.SalaryPaidService;

@RestController
@RequestMapping("/payroll")
@CrossOrigin(origins ="http://localhost:4200", maxAge = 3600)
public class SalaryPaidResource {

	@Autowired
	private SalaryPaidService salaryPaidService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	@GetMapping("/getsalary")
	public SalaryPaid getPaidSalary(@RequestParam String empid, @RequestParam String date) {
		  
		
		
		  InstanceInfo info = eurekaClient.getNextServerFromEureka("travel", false);
		  String homePageUrl=info.getHomePageUrl() + "travelallowancebydate";
		  
		  
		  HttpHeaders headers = new HttpHeaders(); headers.set("Accept",
		  MediaType.APPLICATION_JSON_VALUE);
		  
		  
		  UriComponentsBuilder queryParam =
		  UriComponentsBuilder.fromHttpUrl(homePageUrl) .queryParam("startdate", date)
		  .queryParam("empid", empid);
		  
		  HttpEntity<?> entity = new HttpEntity<>(headers);
		  
		  HttpEntity<JSONData> response = restTemplate.exchange(
		  queryParam.toUriString(), HttpMethod.GET, entity, JSONData.class);
		  
		  Double travelAllowance =(Double) response.getBody().getResult();
		 
		
		
		SalaryPaidEntity salaryPaidEntity = new SalaryPaidEntity(Integer.parseInt(empid),LocalDate.parse(date));
		 		 
		return salaryPaidService.getPaidSalary(salaryPaidEntity, travelAllowance);
		//return salaryPaidService.getPaidSalary(salaryPaidEntity, 1);
	}

}
