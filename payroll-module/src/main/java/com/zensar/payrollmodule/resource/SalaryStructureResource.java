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

import com.zensar.payrollmodule.entity.SalaryStructure;
import com.zensar.payrollmodule.service.SalaryStructureService;

@RestController
@RequestMapping("/payroll")
@CrossOrigin(origins ="http://localhost:4200", maxAge = 3600)
public class SalaryStructureResource {
	
	@Autowired
	private SalaryStructureService salaryStructureService;
	
	@PostMapping("/addSalary")
	public SalaryStructure addRoleAndSalary(@RequestBody SalaryStructure salaryStructure) {
		
		return salaryStructureService.addRoleAndSalary(salaryStructure);
	}
	
	@GetMapping("/salary/{roleId}")
	public SalaryStructure getSalaryStructureByRoleId(@PathVariable int roleId) {
		
		return salaryStructureService.getSalaryStructureByRoleId(roleId);
	}
	
	@GetMapping("/salary")
	public Iterable<SalaryStructure> getAllRolesAndSalaryStructure() {
		
		return salaryStructureService.getAllRolesAndSalaryStructure();	
	}

	@PutMapping("/salary/{roleId}")
	public SalaryStructure updateRoleAndSalary(@PathVariable int roleId,@RequestBody SalaryStructure salaryStructure) {
		salaryStructure.setRoldId(roleId);
		return salaryStructureService.updateRoleAndSalary(roleId,salaryStructure);
	}
	
	@DeleteMapping("/salary/{roleId}")
	public void deleteSalaryForRoleById(@PathVariable int roleId) {
		
		salaryStructureService.deleteSalaryForRoleById(roleId);
	}
}
