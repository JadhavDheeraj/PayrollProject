package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.EmployeeDepartmentMapping;
import com.zensar.repository.EmpDepMappingRepository;

@Service
public class EmpDeptMappingServiceImpl implements EmpDeptMappingService {

	@Autowired
	private EmpDepMappingRepository empDepMappingRepository;

	@Override
	public List<EmployeeDepartmentMapping> getAllEmployeeWithDepartment() {

		List<EmployeeDepartmentMapping> empDeptMapList = empDepMappingRepository.findAll();
		if (empDeptMapList.size() > 0) {
			return empDeptMapList;
		}

		return new ArrayList<EmployeeDepartmentMapping>();
	}

	@Override
	public EmployeeDepartmentMapping getEmployeeWithDepartment(int id) {

		Optional<EmployeeDepartmentMapping> empDeptMap = empDepMappingRepository.findById(id);
		if (empDeptMap.isPresent()) {
			return empDeptMap.get();
		}
		return new EmployeeDepartmentMapping();
	}

	@Override
	public EmployeeDepartmentMapping createOrUpdateEmpWithDept(EmployeeDepartmentMapping entity) {

		Optional<EmployeeDepartmentMapping> empDeptCreate = empDepMappingRepository.findById(entity.getEmployeeId());
		if (empDeptCreate.isPresent()) {
			EmployeeDepartmentMapping newEntity = empDeptCreate.get();
			newEntity.setDepartmentId(newEntity.getDepartmentId());
			newEntity = empDepMappingRepository.save(newEntity);
			return newEntity;
		} else {
			entity = empDepMappingRepository.save(entity);
			return entity;
		}
	}

	@Override
	public void deleteEmployeeWithDepartment(int id) {
		Optional<EmployeeDepartmentMapping> delEmpDept = empDepMappingRepository.findById(id);
		if (delEmpDept.isPresent()) {
			empDepMappingRepository.deleteById(id);
		}

	}

}
