package com.zensar.service;

import java.util.List;

import com.zensar.entity.Department;

public interface DepartmentService {
	
	public List<Department> getAllDepartment();
	
	public Department getDepartmentById(int id);
	
	public Department createOrUpdateDepartment(Department entity);
	
	public void deleteDepartment(int id);

}
