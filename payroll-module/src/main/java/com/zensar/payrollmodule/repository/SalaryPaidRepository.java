package com.zensar.payrollmodule.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zensar.payrollmodule.entity.SalaryPaid;
import com.zensar.payrollmodule.entity.SalaryPaidEntity;

@Repository
public interface SalaryPaidRepository extends CrudRepository<SalaryPaid, SalaryPaidEntity> {


	
	
}
