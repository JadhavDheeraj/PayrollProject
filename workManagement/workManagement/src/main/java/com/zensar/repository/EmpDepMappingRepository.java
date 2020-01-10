package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.EmployeeDepartmentMapping;

@Repository
public interface EmpDepMappingRepository extends JpaRepository<EmployeeDepartmentMapping, Integer>{

}
