package com.zensar.travelling.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zensar.travelling.entity.Cities;
import com.zensar.travelling.entity.LocationKnowldge;

@Repository
public interface IShortestPathRepository
{
	
	List<Cities> getAllCities();

	List<LocationKnowldge> getAllEdgeData();

	Integer getCityIndex(String cityName);

}
