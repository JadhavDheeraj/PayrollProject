package com.zensar.payrollmodule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Entity()
public class SalaryStructure {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Positive
	private int roleId;
	@NotNull
	private String roleName;
	@NotNull
	private double basic;
	@NotNull
	private double hra;
	@NotNull
	private int performanceLevel;
	
	public SalaryStructure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalaryStructure(int roleId, String roleName, double basic, double hra, int performanceLevel) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.basic = basic;
		this.hra = hra;
		this.performanceLevel = performanceLevel;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(basic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + performanceLevel;
		result = prime * result + roleId;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		SalaryStructure other = (SalaryStructure) obj;
		if (Double.doubleToLongBits(basic) != Double.doubleToLongBits(other.basic))
			return false;
		if (Double.doubleToLongBits(hra) != Double.doubleToLongBits(other.hra))
			return false;
		if (performanceLevel != other.performanceLevel)
			return false;
		if (roleId != other.roleId)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoldId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public int getPerformanceLevel() {
		return performanceLevel;
	}
	public void setPerformanceLevel(int performanceLevel) {
		this.performanceLevel = performanceLevel;
	}
	@Override
	public String toString() {
		return "Salary_Structure [roleId=" + roleId + ", roleName=" + roleName + ", basic=" + basic + ", hra=" + hra
				+ ", performanceLevel=" + performanceLevel + "]";
	}
	
	

}
