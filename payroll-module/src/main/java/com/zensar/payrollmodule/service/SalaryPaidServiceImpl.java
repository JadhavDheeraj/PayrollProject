package com.zensar.payrollmodule.service;

import java.time.LocalDate;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.payrollmodule.entity.Employee;
import com.zensar.payrollmodule.entity.SalaryPaid;
import com.zensar.payrollmodule.entity.SalaryPaidEntity;
import com.zensar.payrollmodule.repository.EmployeeRepository;
import com.zensar.payrollmodule.repository.EmployeeRoleMappingRepository;
import com.zensar.payrollmodule.repository.SalaryPaidRepository;
import com.zensar.payrollmodule.repository.SalaryStructureRepository;
import com.zensar.payrollmodule.workmanagement.WorkManagement;
import com.zensar.payrollmodule.workmanagement.WorkManagementRepository;

@Service
public class SalaryPaidServiceImpl implements SalaryPaidService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SalaryStructureRepository salaryStructureRepository;
	
	@Autowired
	private EmployeeRoleMappingRepository employeeRoleMappingRepository;
	
	@Autowired
	private WorkManagementRepository workManagementRepository;

	@Override
	public SalaryPaid getPaidSalary(SalaryPaidEntity salaryPaidEntity, double travelAllowance) {
		
		SalaryPaid salaryPaid = new SalaryPaid(); 
		
		salaryPaid.setEntity(salaryPaidEntity);
		  
		  salaryPaid.setBase(salaryStructureRepository.
		  findById(employeeRoleMappingRepository.
		  findById(salaryPaidEntity.getEmployeeId()).get().getRoleId()). get().
		  getBasic());
		  
		  salaryPaid.setHra(salaryStructureRepository.
		  findById(employeeRoleMappingRepository.
		  findById(salaryPaidEntity.getEmployeeId()).get().getRoleId()). get().
		  getHra());
		  
		  salaryPaid.setTravelAllowance(travelAllowance);  
		  
		  double performanceLevel =salaryStructureRepository.
				  findById(employeeRoleMappingRepository.
						  findById(salaryPaidEntity.getEmployeeId()).get().getRoleId()). get().
						  getPerformanceLevel();
		  
		 // salaryPaid.setBonus(1);
		  
		
		  WorkManagement workManagement =
		  workManagementRepository.findByEmployeeId(salaryPaidEntity.getEmployeeId());
		  
		 salaryPaid.setBonus(workManagement.getWorkCompletion());
		 
		
		return salaryPaid;
	}

	/*
	 * @Override public SalaryPaid getPaidSalary(String employeeId, String
	 * startDate, String endDate) {
	 * 
	 * SalaryPaid salaryPaid = new SalaryPaid();
	 * 
	 * employeeRoleMappingRepository.findById(employeeId).get();
	 * 
	 * salaryPaid.setBase()
	 * 
	 * return null; }
	 */

	
	
	
	
	
	
}
