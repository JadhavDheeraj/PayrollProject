package com.zensar.payrollmodule.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class SalaryPaid implements Serializable{
	
	@EmbeddedId
	@NotNull
	private SalaryPaidEntity entity;
	
	@NotNull
	private double base;
	@NotNull
	private double hra;
	@NotNull
	private double travelAllowance;
	@NotNull
	private double bonus;
	
	public SalaryPaid(SalaryPaidEntity entity, double base, double hra, double travelAllowance, double bonus) {
		super();
		this.entity = entity;
		this.base = base;
		this.hra = hra;
		this.travelAllowance = travelAllowance;
		this.bonus = bonus;
	}
	public SalaryPaid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalaryPaidEntity getEntity() {
		return entity;
	}
	public void setEntity(SalaryPaidEntity entity) {
		this.entity = entity;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getTravelAllowance() {
		return travelAllowance;
	}
	public void setTravelAllowance(double travelAllowance) {
		this.travelAllowance = travelAllowance;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "SalaryPaid [entity=" + entity + ", base=" + base + ", hra=" + hra + ", travelAllowance="
				+ travelAllowance + ", bonus=" + bonus + "]";
	}
	
	
	

}
