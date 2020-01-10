package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Department;
import com.zensar.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartment() {
		List<Department> deptList = departmentRepository.findAll();
		if(deptList.size() > 0) {
			return deptList;
		}
		else {
			return new ArrayList<Department>();
		}
	}
	
	@Override
	public Department getDepartmentById(int id) {
		Optional<Department> dept = departmentRepository.findById(id);
		if(dept.isPresent()) {
			return dept.get();
		}
		return new Department();
	}

	@Override
	public Department createOrUpdateDepartment(Department entity) {
		Optional<Department> dept = departmentRepository.findById(entity.getDepartmentId());
		if (dept.isPresent()) {
			Department newEntity = dept.get();
			newEntity.setDepartmentName(entity.getDepartmentName());
			newEntity = departmentRepository.save(newEntity);
			return newEntity;
			}
		else
			entity= departmentRepository.save(entity);
		return entity;
	}

	@Override
	public void deleteDepartment(int id) {
		Optional<Department> delDept = departmentRepository.findById(id);
		if(delDept.isPresent()) {
			departmentRepository.deleteById(id);
		}
		
	}

}
