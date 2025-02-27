package com.zensar.payrollmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.payrollmodule.entity.Employee;
import com.zensar.payrollmodule.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int empId) {

		return employeeRepository.findById(empId).get();
	}

	@Override
	public Iterable<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(int empId, Employee employee) {
		
		System.out.println(empId);
		System.out.println(employee.toString());
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int empId) {

		employeeRepository.deleteById(empId);
	}
	
	

}
