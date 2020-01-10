package com.zensar.service;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.entity.EmployeeWork;
import com.zensar.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeWork> getAllEmployee() {
		List<EmployeeWork> employeeList = employeeRepository.findAll();
		if (employeeList.size() > 0)
			return employeeList;
		else
			return new ArrayList<EmployeeWork>();
	}

	@Override
	public EmployeeWork getEmployeeById(int id) {
		Optional<EmployeeWork> employee = employeeRepository.findById(id);
		if (employee.isPresent())
			return employee.get();
		else
			return new EmployeeWork();
	}

	@Override
	public EmployeeWork createOrUpdateEmployee(EmployeeWork entity) {
		Optional<EmployeeWork> employee = employeeRepository.findById(entity.getEmployeeId());
		if (employee.isPresent()) {
			EmployeeWork newEntity = employee.get();
			newEntity.setWorkCompletionPercentage(entity.getWorkCompletionPercentage());
			newEntity = employeeRepository.save(newEntity);

			return newEntity;
		} else {

			entity = employeeRepository.save(entity);
			return entity;
		}

	}

	@Override
	public void deleteEmployeeById(int id) {
		Optional<EmployeeWork> employee = employeeRepository.findById(id);
		if (employee.isPresent())
			employeeRepository.deleteById(id);
	}

	@Override
	public Double getEmployeeWorkByDate(Integer empID, LocalDate date) {
		
		LocalDate startDateOfMonth = date.withDayOfMonth(1);
		LocalDate endDateOfMonth = date.with(lastDayOfMonth());

		System.out.println(startDateOfMonth+" "+endDateOfMonth);
		
		
		Optional<List<EmployeeWork>> employeewithMultipleRecordList = employeeRepository.findByEmployeeIdAndDateBetween(empID,startDateOfMonth,endDateOfMonth);
				
		
		if (employeewithMultipleRecordList.isPresent()) {
			
			Double workCompletionPercentage=0.0;
			
			for(EmployeeWork employeeWorkRecord:employeewithMultipleRecordList.get())
			{
				 workCompletionPercentage= workCompletionPercentage+employeeWorkRecord.getWorkCompletionPercentage();
			}

			System.out.println(employeewithMultipleRecordList.get());
			return (workCompletionPercentage/employeewithMultipleRecordList.get().size());
			
			//return newEvntity;
		} else {

			return null;
		
		}
	}
}
