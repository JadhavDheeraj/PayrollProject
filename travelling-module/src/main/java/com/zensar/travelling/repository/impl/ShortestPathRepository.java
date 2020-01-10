package com.zensar.travelling.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zensar.travelling.entity.Cities;
import com.zensar.travelling.entity.LocationKnowldge;
import com.zensar.travelling.repository.IShortestPathRepository;

@Repository
public class ShortestPathRepository implements IShortestPathRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<LocationKnowldge> getAllEdgeData() {

		// .getTransaction().begin();

		@SuppressWarnings("unchecked")
		List<LocationKnowldge> listLocationKnowldge = entityManager.createQuery("SELECT l FROM LocationKnowldge l")
				.getResultList();
		System.out.println(listLocationKnowldge);

		return listLocationKnowldge;
	}

	@Override
	public List<Cities> getAllCities() {
		@SuppressWarnings("unchecked")
		List<Cities> listOfCity = entityManager.createQuery("SELECT c FROM Cities c").getResultList();
		// System.out.println(listOfCity);
		return listOfCity;
	}

	@Override
	public Integer getCityIndex(String cityName) {
		System.out.println("------>" + cityName);
		try {

			Query query = entityManager.createQuery("from Cities where city=:cityname");
			query.setParameter("cityname", cityName);

			Cities city = (Cities) query.getSingleResult();
			return city.getId();

		} catch (Exception e) {
			System.out.println("for "+cityName+"record not available");
			return -1;
		}
		

	}
}
