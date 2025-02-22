package com.zensar.payrollmodule.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.payrollmodule.entity.EmployeeRoleMapping;
import com.zensar.payrollmodule.service.EmployeeRoleMappingService;

@RestController
@RequestMapping("/payroll")
public class EmployeeAndRoleMappingResource {

	@Autowired
	private EmployeeRoleMappingService employeeRoleMappingService;

	@PostMapping("/addRole")
	public EmployeeRoleMapping addRole(@RequestBody EmployeeRoleMapping employeeRoleMapping) {

		return employeeRoleMappingService.addRole(employeeRoleMapping);
	}

	@GetMapping("/role/{empId}")
	public EmployeeRoleMapping getRoleById(@PathVariable int empId) {
		return employeeRoleMappingService.getRoleById(empId);
	}

	@GetMapping("/role")
	public Iterable<EmployeeRoleMapping> getAllRoles() {
		return employeeRoleMappingService.getAllRoles();
	}

	@PutMapping("/role/{empId}")
	public EmployeeRoleMapping updateRole(@PathVariable int empId,@RequestBody EmployeeRoleMapping employeeRoleMapping) {
		employeeRoleMapping.setEmployeeId(empId);
		return employeeRoleMappingService.updateRole(empId, employeeRoleMapping);
	}

	@DeleteMapping("/role/{empId}")
	public void deleteRole(@PathVariable int empId) {
		employeeRoleMappingService.deleteRole(empId);
	}

}
