package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
