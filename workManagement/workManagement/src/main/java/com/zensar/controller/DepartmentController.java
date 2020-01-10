package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Department;
import com.zensar.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartment() {
		List<Department> list = departmentService.getAllDepartment();
		return new ResponseEntity<List<Department>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id) {
		Department entity = departmentService.getDepartmentById(id);
		return new ResponseEntity<Department>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Department> createOrUpdateDepartment(@RequestBody Department department) {
		Department updated = departmentService.createOrUpdateDepartment(department);
		return new ResponseEntity<Department>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	/*
	 * @PutMapping public ResponseEntity<Department>
	 * createOrUpdateEmployee2(@RequestBody Department department) { Department
	 * updated = departmentService.createOrUpdateDepartment(department); return new
	 * ResponseEntity<Department>(updated, new HttpHeaders(), HttpStatus.OK); }
	 */

	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") int id) {
		departmentService.deleteDepartment(id);
		return HttpStatus.FORBIDDEN;
	}

}
