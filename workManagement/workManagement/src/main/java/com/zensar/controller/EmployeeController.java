package com.zensar.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.service.EmployeeService;

@RestController
@RequestMapping("/employeeWork")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/*
	 * @GetMapping("/") public String getData() { return "data get"; }
	 

	@GetMapping
	public ResponseEntity<List<EmployeeWork>> getAllEmployees() {
		List<EmployeeWork> list = employeeService.getAllEmployee();

		return new ResponseEntity<List<EmployeeWork>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeWork> getEmployeeById(@PathVariable("id") int id) {
		EmployeeWork entity = employeeService.getEmployeeById(id);
		return new ResponseEntity<EmployeeWork>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EmployeeWork> createOrUpdateEmployee(@RequestBody EmployeeWork employee) {
		EmployeeWork updated = employeeService.createOrUpdateEmployee(employee);
		return new ResponseEntity<EmployeeWork>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	*/
	/*
	 * @PutMapping public ResponseEntity<EmployeeWork>
	 * createOrUpdateEmployee2(@RequestBody EmployeeWork employee) { EmployeeWork
	 * updated = employeeService.createOrUpdateEmployee(employee); return new
	 * ResponseEntity<EmployeeWork>(updated, new HttpHeaders(), HttpStatus.OK); }
	 */
	// https://github.com/piyushewale/PayrollRepo

	/*@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") int id) {
		employeeService.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}
	*/
	/*
	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeWork> getEmployeeById(@PathVariable("empId") int id) {
		EmployeeWork entity = employeeService.getEmployeeById(id);
		return new ResponseEntity<EmployeeWork>(entity, new HttpHeaders(), HttpStatus.OK);
	}
*/
	
	@GetMapping("/getemployeeworkbydate")
	public Double getEmployeeWorkByDate(@RequestParam(name="empid")String empid,
										   @RequestParam(name="startdate")String startdate)
	{
		System.out.println(empid+" "+startdate);
		
		Integer convertEmpid=Integer.parseInt(empid);
		LocalDate convertStartdate=LocalDate.parse(startdate);		
		return employeeService.getEmployeeWorkByDate(convertEmpid,convertStartdate);	
	}

}
