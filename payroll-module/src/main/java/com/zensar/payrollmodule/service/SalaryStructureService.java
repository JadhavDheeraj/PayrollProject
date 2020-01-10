package com.zensar.payrollmodule.service;

import com.zensar.payrollmodule.entity.SalaryStructure;

public interface SalaryStructureService {

	public SalaryStructure addRoleAndSalary(SalaryStructure salaryStructure);
	
	public SalaryStructure getSalaryStructureByRoleId(int roleId);
	
	public Iterable<SalaryStructure> getAllRolesAndSalaryStructure();
	
	public SalaryStructure updateRoleAndSalary(int roleId,SalaryStructure salaryStructure);
	
	public void deleteSalaryForRoleById(int roleId);

}
