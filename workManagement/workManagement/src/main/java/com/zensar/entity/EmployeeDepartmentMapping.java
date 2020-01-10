package com.zensar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeDepartmentMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;

	@Column(name = "department_id")
	private Integer departmentId;

	public EmployeeDepartmentMapping() {
	}

	public EmployeeDepartmentMapping(int employeeId, Integer departmentId) {
		super();
		this.employeeId = employeeId;
		this.departmentId = departmentId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/*
	 * @Override public String toString() { return
	 * "EmployeeDepartmentMapping [employeeId=" + employeeId + ", departmentId=" +
	 * departmentId + "]"; }
	 */
}
