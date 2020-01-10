package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zensar.entity.EmployeeDepartmentMapping;
import com.zensar.service.EmpDeptMappingService;

@Controller
@RequestMapping("/empDeptMap")
public class EmpDeptMappingController {

	@Autowired
	private EmpDeptMappingService empDeptMappingService;

	@GetMapping
	public ResponseEntity<List<EmployeeDepartmentMapping>> getAllEmployeeWithDepartment() {
		List<EmployeeDepartmentMapping> list = empDeptMappingService.getAllEmployeeWithDepartment();
		return new ResponseEntity<List<EmployeeDepartmentMapping>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDepartmentMapping> getDepartmentById(@PathVariable("id") int id) {
		EmployeeDepartmentMapping entity = empDeptMappingService.getEmployeeWithDepartment(id);
		return new ResponseEntity<EmployeeDepartmentMapping>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EmployeeDepartmentMapping> createOrUpdateDepartment(
			@RequestBody EmployeeDepartmentMapping empDeptMap) {
		EmployeeDepartmentMapping updated = empDeptMappingService.createOrUpdateEmpWithDept(empDeptMap);
		return new ResponseEntity<EmployeeDepartmentMapping>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<EmployeeDepartmentMapping> createOrUpdateEmployee2(
			@RequestBody EmployeeDepartmentMapping empDeptMap) {
		EmployeeDepartmentMapping updated = empDeptMappingService.createOrUpdateEmpWithDept(empDeptMap);
		return new ResponseEntity<EmployeeDepartmentMapping>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") int id) {
		empDeptMappingService.deleteEmployeeWithDepartment(id);
		return HttpStatus.FORBIDDEN;
	}

}
