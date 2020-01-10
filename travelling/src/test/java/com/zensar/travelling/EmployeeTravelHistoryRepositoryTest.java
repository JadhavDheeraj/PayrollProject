package com.zensar.travelling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.zensar.travelling.entity.Cities;
import com.zensar.travelling.entity.EmployeeTravelHistory;
import com.zensar.travelling.entity.LocationKnowldge;
import com.zensar.travelling.repository.IEmployeeTravelHistoryRepository;
import com.zensar.travelling.repository.impl.ShortestPathRepository;
import com.zensar.travelling.service.IShortestPathService;
import com.zensar.travelling.service.exception.JSONData;
import com.zensar.travelling.service.impl.EmployeeTravelHistoryService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTravelHistoryRepositoryTest {
	
	@InjectMocks
	EmployeeTravelHistoryService employeeTravelHistoryService;
	
	@Mock
	ShortestPathRepository shortestPathRepository;

	@Autowired
	@Mock
	private IEmployeeTravelHistoryRepository travelHistoryRepository; 
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getTravelHistory() {
		
		EmployeeTravelHistory travelHistory1=new EmployeeTravelHistory();
		travelHistory1.setEmpid(141);
		travelHistory1.setDate(LocalDate.parse("2020-01-01"));
		travelHistory1.setSourceCity("Pune");
		travelHistory1.setDestinationCity("Delhi");
		travelHistory1.setTotalAllowance(250.0);
		
		EmployeeTravelHistory travelHistory2=new EmployeeTravelHistory();
		travelHistory2.setEmpid(141);
		travelHistory2.setDate(LocalDate.parse("2020-01-15"));
		travelHistory2.setSourceCity("Pune");
		travelHistory2.setDestinationCity("Noida");
		travelHistory2.setTotalAllowance(150.0);
		
		
		List<EmployeeTravelHistory> tempETHistoryList=new ArrayList<>();
		tempETHistoryList.add(travelHistory1);
		tempETHistoryList.add(travelHistory2);
		
		System.out.println(travelHistoryRepository.findByEmpid(141));
		
		System.out.println(employeeTravelHistoryService.getTravelHistory(141));
		
		when(employeeTravelHistoryService.getTravelHistory(141).getResult()).thenReturn(tempETHistoryList);
		
		JSONData travelHistory = employeeTravelHistoryService.getTravelHistory(141);
		@SuppressWarnings("unchecked")
		List<EmployeeTravelHistory> dbETHList =(List<EmployeeTravelHistory>) travelHistory.getResult();
		
		assertEquals(travelHistory1.getTotalAllowance(),dbETHList.get(0).getTotalAllowance());
		
//		19	2020-01-01	Noida	141	Pune	250
	//	20	2020-01-15	Delhi	141	Pune	150
		
		/*
		Double sumOfAllowance=0.0;
		
		for(EmployeeTravelHistory employeeTravelHistory:tempETHistoryList)
		{
			sumOfAllowance=sumOfAllowance+employeeTravelHistory.getTotalAllowance();
		}	
		*/
		
		
		
		
		
	}

	

	

}
