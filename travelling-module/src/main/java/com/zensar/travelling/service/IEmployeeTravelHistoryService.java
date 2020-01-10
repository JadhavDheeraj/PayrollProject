package com.zensar.travelling.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.zensar.travelling.entity.EmployeeTravelHistory;
import com.zensar.travelling.service.exception.JSONData;

@Service
public interface IEmployeeTravelHistoryService {

	JSONData savetravelhistory(EmployeeTravelHistory travelHistory);

	JSONData getTravelHistory(Integer eid);

	JSONData getTravelHistoryByDate(Integer empid, LocalDate startdate, LocalDate enddate);

	JSONData getTravelAllowanceByDate(Integer empid, LocalDate startdate, LocalDate enddate);

}
