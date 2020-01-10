package com.zensar.payrollmodule.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.payrollmodule.entity.Employee;
import com.zensar.payrollmodule.service.EmployeeService;

@RestController
@RequestMapping("/payroll")
@CrossOrigin(origins ="http://localhost:4200", maxAge = 3600)
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
		
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable int empId) {
		
		System.out.println(empId);
		System.out.println(employeeService.getEmployeeById(empId));
		return employeeService.getEmployeeById(empId);
	}
	
	@GetMapping("/employee")
	
	public Iterable<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	
	@PutMapping("/employee/{empId}")
	public Employee updateEmployee(@PathVariable int empId,@RequestBody Employee employee) {
		employee.setEmployeeId(empId);
		return employeeService.updateEmployee(empId,employee);
	}
	
	
	@DeleteMapping("/employee/{empId}")
	public void deleteEmployee(@PathVariable int empId) {
		
		employeeService.deleteEmployee(empId);
	}

}
