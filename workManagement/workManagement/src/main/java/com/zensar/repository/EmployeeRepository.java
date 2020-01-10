package com.zensar.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.EmployeeWork;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeWork, Integer>{

	Optional<List<EmployeeWork>> findByEmployeeIdAndDateBetween(Integer empID, LocalDate startDateOfMonth, LocalDate endDateOfMonth);

}
