package com.zensar.payrollmodule.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class EmployeeRoleMapping {
	
	@Id
	@NotNull
	@Positive
	private int employeeId;
	
	@NotNull
	@Positive
	private int roleId;

	public EmployeeRoleMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRoleMapping(int employeeId, int roleId) {
		super();
		this.employeeId = employeeId;
		this.roleId = roleId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "EmployeeRoleMapping [employeeId=" + employeeId + ", roleId=" + roleId + "]";
	}
	
	

}
