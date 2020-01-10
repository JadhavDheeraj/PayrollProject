package com.zensar.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Employee_work")
public class EmployeeWork {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int employeeId;
	
	@Column(name="workdate")
	private LocalDate date;
	
	/*
	 * @Column(name="department_id") private Integer departmentId;
	 */
	 
	@Column(name="work_completion_percentage") 
	private Double workCompletionPercentage;
	
	/*
	 * @Column(name="role_id") private Integer roleId;
	 */
	
	public EmployeeWork() {
		
	}
	
	public EmployeeWork(Integer employeeId, LocalDate date, Double workCompletionPercentage) {
		super();
		this.employeeId = employeeId;
		this.date = date;
		this.workCompletionPercentage = workCompletionPercentage;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public double getWorkCompletionPercentage() {
		return workCompletionPercentage;
	}
	public void setWorkCompletionPercentage(Double workCompletionPercentage) {
		this.workCompletionPercentage = workCompletionPercentage;
	}
	

	@Override
	public String toString() {
		return "EmployeeWork [employeeId=" + employeeId + ", date=" + date + ", workCompletionPercentage=" 
	+ workCompletionPercentage  + "]";
	}
	
	
}
