package com.zensar.travelling.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class EmployeeTravelHistory {

	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;	
	private Integer empid;
	private LocalDate date;
	private String sourceCity;
	private String destinationCity;
	private Double totalAllowance;
	
	public EmployeeTravelHistory() {
	
	}

	public EmployeeTravelHistory(Integer id, Integer empid, LocalDate date, String sourceCity, String destinationCity,
			Double totalAllowance) {
		this.id = id;
		this.empid = empid;
		this.date = date;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.totalAllowance = totalAllowance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Double getTotalAllowance() {
		return totalAllowance;
	}

	public void setTotalAllowance(Double totalAllowance) {
		this.totalAllowance = totalAllowance;
	}

	@Override
	public String toString() {
		return "EmployeeTravelHistory [id=" + id + ", empid=" + empid + ", date=" + date + ", sourceCity=" + sourceCity
				+ ", destinationCity=" + destinationCity + ", totalAllowance=" + totalAllowance + "]";
	}

	
	
	
	
	
	
}
