package com.zensar.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.zensar.entity.EmployeeWork;


public interface EmployeeService {
	
	public List<EmployeeWork> getAllEmployee();
	
	public EmployeeWork getEmployeeById(int id);
	
	public EmployeeWork createOrUpdateEmployee(EmployeeWork entity);
	
	public void deleteEmployeeById(int id);

	public Double getEmployeeWorkByDate(Integer empId, LocalDate startDateOfMonth);
	
	}
