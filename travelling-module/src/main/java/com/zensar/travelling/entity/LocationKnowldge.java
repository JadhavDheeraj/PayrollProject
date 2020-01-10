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
public class LocationKnowldge {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;
	private String sourceCity;
	private String destinationCity;
	private Integer distance;
	
	LocationKnowldge()
	{
		
	}	
	
	public LocationKnowldge(Integer id, String sourceCity, String destinationCity, Integer distance) {
		this.id = id;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.distance = distance;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "LocationKnowldge [id=" + id + ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity
				+ ", distance=" + distance + "]";
	}
	
	

	
	
	
	
}
