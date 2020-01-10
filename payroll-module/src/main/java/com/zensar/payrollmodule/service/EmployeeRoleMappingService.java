package com.zensar.payrollmodule.service;

import com.zensar.payrollmodule.entity.EmployeeRoleMapping;

public interface EmployeeRoleMappingService {
	
	public EmployeeRoleMapping addRole(EmployeeRoleMapping employeeRoleMapping);
	
	public EmployeeRoleMapping getRoleById(int empId);
	
	public Iterable<EmployeeRoleMapping> getAllRoles();
	
	public EmployeeRoleMapping updateRole(int empId,EmployeeRoleMapping employeeRoleMapping);
	
	public void deleteRole(int empId);
	

}
