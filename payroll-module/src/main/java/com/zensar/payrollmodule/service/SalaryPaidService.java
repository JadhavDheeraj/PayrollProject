package com.zensar.payrollmodule.service;

import com.zensar.payrollmodule.entity.SalaryPaid;
import com.zensar.payrollmodule.entity.SalaryPaidEntity;

public interface SalaryPaidService {

	public SalaryPaid getPaidSalary(SalaryPaidEntity salaryPaidEntity, double travelAllowance);

	//public SalaryPaid getPaidSalary(String employeeId, String startDate, String endDate);
	

	//public SalaryPaid addPaidSalary();
	

}
