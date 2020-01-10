package com.zensar.travelling.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.travelling.constants.TravellingConstants;
import com.zensar.travelling.entity.EmployeeTravelHistory;
import com.zensar.travelling.repository.IEmployeeTravelHistoryRepository;
import com.zensar.travelling.service.IEmployeeTravelHistoryService;
import com.zensar.travelling.service.IShortestPathService;
import com.zensar.travelling.service.exception.JSONData;

@Service
public class EmployeeTravelHistoryService implements IEmployeeTravelHistoryService {

	@Autowired
	private IEmployeeTravelHistoryRepository travelHistoryRepository; 
	
	@Autowired
	private IShortestPathService shortestPathService;
	
	@Override
	public JSONData savetravelhistory(EmployeeTravelHistory travelHistory) {
		
		//travelHisto
		EmployeeTravelHistory teEmployeeTravelHistory=new EmployeeTravelHistory();
		teEmployeeTravelHistory.setEmpid(travelHistory.getEmpid());
		teEmployeeTravelHistory.setDate(travelHistory.getDate());		
		teEmployeeTravelHistory.setSourceCity(travelHistory.getSourceCity());
		teEmployeeTravelHistory.setDestinationCity(travelHistory.getDestinationCity());		
		
		JSONData shortestPathDistance = shortestPathService.getShortestPathDistance(travelHistory.getSourceCity(),travelHistory.getDestinationCity());
		Integer shortestDistance=(Integer)shortestPathDistance.getResult();
		
		System.out.println("shortestDistance---"+shortestDistance);
		
		Double totalAllowance=shortestDistance* TravellingConstants.RATEPERKM;
		
		teEmployeeTravelHistory.setTotalAllowance(totalAllowance);
		
		EmployeeTravelHistory employeeTravelHistory = travelHistoryRepository.save(teEmployeeTravelHistory);
		
		return new JSONData("sucess",1,employeeTravelHistory);
	}

	@Override
	public JSONData getTravelHistory(Integer eid) {

		List<EmployeeTravelHistory> tempETHistoryList = travelHistoryRepository.findByEmpid(eid);
		return new JSONData("sucess",1,tempETHistoryList);
	}

	@Override
	public JSONData getTravelHistoryByDate(Integer empid, LocalDate startdate, LocalDate enddate) {
		
	//	List<EmployeeTravelHistory> tempETHistoryList = travelHistoryRepository.findByDateBetween(startdate,enddate);
		List<EmployeeTravelHistory> tempETHistoryList = travelHistoryRepository.findByEmpidAndDateBetween(empid, startdate, enddate);		
		return new JSONData("sucess",1,tempETHistoryList);

	}

	@Override
	public JSONData getTravelAllowanceByDate(Integer empid, LocalDate startdate, LocalDate enddate) {
		
	//	List<EmployeeTravelHistory> tempETHistoryList = travelHistoryRepository.findByDateBetween(startdate,enddate);
		List<EmployeeTravelHistory> tempETHistoryList = travelHistoryRepository.findByEmpidAndDateBetween(empid, startdate, enddate);		
		
		Double sumOfAllowance=0.0;
		
		for(EmployeeTravelHistory employeeTravelHistory:tempETHistoryList)
		{
			sumOfAllowance=sumOfAllowance+employeeTravelHistory.getTotalAllowance();
		}		
		
		return new JSONData("sumofAllowance",1,sumOfAllowance);

	}
	
}
