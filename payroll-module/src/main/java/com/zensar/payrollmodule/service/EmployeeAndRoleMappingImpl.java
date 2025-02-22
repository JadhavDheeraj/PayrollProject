package com.zensar.payrollmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.payrollmodule.entity.EmployeeRoleMapping;
import com.zensar.payrollmodule.repository.EmployeeRoleMappingRepository;


@Service
public class EmployeeAndRoleMappingImpl implements EmployeeRoleMappingService{
	
	@Autowired
	private EmployeeRoleMappingRepository employeeRoleMappingRepository;
	

	@Override
	public EmployeeRoleMapping addRole(EmployeeRoleMapping employeeRoleMapping) {
		// TODO Auto-generated method stub
		return employeeRoleMappingRepository.save(employeeRoleMapping);
	}

	@Override
	public EmployeeRoleMapping getRoleById(int empId) {
		// TODO Auto-generated method stub
		return employeeRoleMappingRepository.findById(empId).get();
	}

	@Override
	public Iterable<EmployeeRoleMapping> getAllRoles() {
		// TODO Auto-generated method stub
		return employeeRoleMappingRepository.findAll();
	}

	@Override
	public EmployeeRoleMapping updateRole(int empId, EmployeeRoleMapping employeeRoleMapping) {
		// TODO Auto-generated method stub
		return employeeRoleMappingRepository.save(employeeRoleMapping);
	}

	@Override
	public void deleteRole(int empId) {
		// TODO Auto-generated method stub
		employeeRoleMappingRepository.deleteById(empId);
	}
}
