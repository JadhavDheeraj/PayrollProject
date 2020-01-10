package com.zensar.service;

import java.util.List;

import com.zensar.entity.EmployeeDepartmentMapping;

public interface EmpDeptMappingService {
	
	public List<EmployeeDepartmentMapping> getAllEmployeeWithDepartment();
	
	public EmployeeDepartmentMapping getEmployeeWithDepartment(int id);
	
	public EmployeeDepartmentMapping createOrUpdateEmpWithDept(EmployeeDepartmentMapping entity);
	
	public void deleteEmployeeWithDepartment(int id);

}
