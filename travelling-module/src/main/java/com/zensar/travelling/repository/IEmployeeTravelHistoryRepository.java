package com.zensar.travelling.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zensar.travelling.entity.EmployeeTravelHistory;

@Repository
public interface IEmployeeTravelHistoryRepository extends CrudRepository<EmployeeTravelHistory, Integer> {

	public List<EmployeeTravelHistory> findByEmpid(Integer empid);

	public List<EmployeeTravelHistory> findByDateBetween(LocalDate startdate, LocalDate enddate);

	public List<EmployeeTravelHistory> findByEmpidAndDateBetween(Integer empid,LocalDate startdate, LocalDate enddate);
	
}
