package com.zensar.travelling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.zensar.travelling.entity.Cities;
import com.zensar.travelling.entity.LocationKnowldge;
import com.zensar.travelling.repository.impl.ShortestPathRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestShortestPathRepository {

	@Mock
	ShortestPathRepository shortestPathRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCityIndexTest() {
		Cities cityName = new Cities(5, "Chennai");

		when(shortestPathRepository.getCityIndex("Chennai")).thenReturn(cityName.getId());

		Integer index = shortestPathRepository.getCityIndex("Chennai");

		assertEquals(index, cityName.getId());

	}

	@Test
	public void getAllEdgeDataTest() {

		List<LocationKnowldge> edgeList = new ArrayList<>();
		edgeList.add(new LocationKnowldge(1, "Delhi", "Pune", 3));
		edgeList.add(new LocationKnowldge(2, "Delhi", "Banglore", 1));
		edgeList.add(new LocationKnowldge(3, "Banglore", "Noida", 2));
		edgeList.add(new LocationKnowldge(4, "Delhi", "Noida", 4));
		edgeList.add(new LocationKnowldge(5, "Noida", "Hydrabad", 2));
		edgeList.add(new LocationKnowldge(6, "Hydrabad", "Chennai", 6));
		edgeList.add(new LocationKnowldge(7, "Pune", "Chennai", 3));
		edgeList.add(new LocationKnowldge(8, "Pune", "Noida", 5));

		when(shortestPathRepository.getAllEdgeData()).thenReturn(edgeList);

		// test
		List<LocationKnowldge> edlist = shortestPathRepository.getAllEdgeData();

		assertEquals(8, edlist.size());
	}

	@Test
	public void getAllCitiesTest() {

		List<Cities> cityList = new ArrayList<>();
		cityList.add(new Cities(0, "Pune"));
		cityList.add(new Cities(1, "Banglore"));
		cityList.add(new Cities(2, "Delhi"));
		cityList.add(new Cities(3, "Noida"));
		cityList.add(new Cities(4, "Hydrabad"));
		cityList.add(new Cities(5, "Chennai"));

		when(shortestPathRepository.getAllCities()).thenReturn(cityList);

		// test
		List<Cities> cilist = shortestPathRepository.getAllCities();

		assertEquals(6, cilist.size());
	}

}
