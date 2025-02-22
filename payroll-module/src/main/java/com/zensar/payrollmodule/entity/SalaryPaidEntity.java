package com.zensar.payrollmodule.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class SalaryPaidEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Integer employeeId;
	
	private LocalDate date;

	public SalaryPaidEntity(int employeeId, LocalDate date) {
		super();
		this.employeeId = employeeId;
		this.date = date;
	}

	public SalaryPaidEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SalaryPaidEntity [employeeId=" + employeeId + ", date=" + date + "]";
	}
	
	
}
