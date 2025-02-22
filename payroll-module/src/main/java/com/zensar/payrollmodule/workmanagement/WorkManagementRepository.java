package com.zensar.payrollmodule.workmanagement;

import org.springframework.data.repository.CrudRepository;

public interface WorkManagementRepository extends CrudRepository<WorkManagement, Integer> {
	
	public WorkManagement findByEmployeeId(int employeeId);

}
