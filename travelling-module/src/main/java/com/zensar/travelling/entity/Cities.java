package com.zensar.travelling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cities {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;
	private String city;
	
	public Cities() {
	
	}
	
	
	public Cities(Integer id, String city) {
		this.id = id;
		this.city = city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Cities [id=" + id + ", city=" + city + "]";
	}
	
	
	
	
}
