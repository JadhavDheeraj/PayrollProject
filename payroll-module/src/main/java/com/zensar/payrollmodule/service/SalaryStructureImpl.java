package com.zensar.payrollmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.payrollmodule.entity.SalaryStructure;
import com.zensar.payrollmodule.repository.SalaryStructureRepository;

@Service
public class SalaryStructureImpl implements SalaryStructureService {

	@Autowired
	private SalaryStructureRepository salaryStructureRepository;
	
	@Override
	public SalaryStructure addRoleAndSalary(SalaryStructure salaryStructure) {

		return salaryStructureRepository.save(salaryStructure);
	}

	@Override
	public SalaryStructure getSalaryStructureByRoleId(int roleId) {

		return salaryStructureRepository.findById(roleId).get();
	}
	
	@Override
	public Iterable<SalaryStructure> getAllRolesAndSalaryStructure(){
		
		return salaryStructureRepository.findAll();
	}

	@Override
	public SalaryStructure updateRoleAndSalary(int roleId,SalaryStructure salaryStructure) {

		return salaryStructureRepository.save(salaryStructure);
	}

	@Override
	public void deleteSalaryForRoleById(int roleId) {

		salaryStructureRepository.deleteById(roleId);
	}
}
