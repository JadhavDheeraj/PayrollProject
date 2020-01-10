package com.zensar.payrollmodule.workmanagement;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkManagement {

	@Id
	private int work_Id;

	private int employeeId;
	private LocalDate date;
	private int departmentId;
	private int workCompletion;
	private int roldId;
	public WorkManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkManagement(int work_Id, int employeeId, LocalDate date, int departmentId, int workCompletion,
			int roldId) {
		super();
		this.work_Id = work_Id;
		this.employeeId = employeeId;
		this.date = date;
		this.departmentId = departmentId;
		this.workCompletion = workCompletion;
		this.roldId = roldId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + departmentId;
		result = prime * result + employeeId;
		result = prime * result + roldId;
		result = prime * result + workCompletion;
		result = prime * result + work_Id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkManagement other = (WorkManagement) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (departmentId != other.departmentId)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (roldId != other.roldId)
			return false;
		if (workCompletion != other.workCompletion)
			return false;
		if (work_Id != other.work_Id)
			return false;
		return true;
	}
	public int getWork_Id() {
		return work_Id;
	}
	public void setWork_Id(int work_Id) {
		this.work_Id = work_Id;
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
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getWorkCompletion() {
		return workCompletion;
	}
	public void setWorkCompletion(int workCompletion) {
		this.workCompletion = workCompletion;
	}
	public int getRoldId() {
		return roldId;
	}
	public void setRoldId(int roldId) {
		this.roldId = roldId;
	}
	@Override
	public String toString() {
		return "WorkManagement [work_Id=" + work_Id + ", employeeId=" + employeeId + ", date=" + date
				+ ", departmentId=" + departmentId + ", workCompletion=" + workCompletion + ", roldId=" + roldId + "]";
	}
	
	

	
}
