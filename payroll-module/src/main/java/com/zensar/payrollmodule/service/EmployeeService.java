package com.zensar.payrollmodule.service;

import com.zensar.payrollmodule.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public Employee getEmployeeById(int empId);
	
	public Iterable<Employee> getAllEmployees();
	
	public Employee updateEmployee(int empId,Employee employee);
	
	public void deleteEmployee(int empId);
}
