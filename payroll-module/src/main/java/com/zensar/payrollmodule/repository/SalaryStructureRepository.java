package com.zensar.payrollmodule.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zensar.payrollmodule.entity.SalaryStructure;

@Repository
public interface SalaryStructureRepository extends CrudRepository<SalaryStructure, Integer> {

}
