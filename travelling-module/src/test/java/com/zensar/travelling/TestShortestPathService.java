package com.zensar.travelling;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.zensar.travelling.repository.impl.ShortestPathRepository;
import com.zensar.travelling.service.IShortestPathService;
import com.zensar.travelling.service.exception.JSONData;
import com.zensar.travelling.service.impl.DijkstraAdjacencyMatrix;
import com.zensar.travelling.service.impl.ShortestPathService;

@RunWith(MockitoJUnitRunner.class)
public class TestShortestPathService {

	@InjectMocks
	ShortestPathService shortestPathService;
	
	@Mock
	ShortestPathRepository shortestPathRepository;
	
	@Mock
	DijkstraAdjacencyMatrix d;
	
	@Mock
	JSONData jsonData;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getShortestPathDistanceTest() {	
		
		Integer d=new Integer(7);
	
		
		when(shortestPathService.getShortestPathDistance("Pune", "Hydrabad").getResult()).thenReturn(d);
		Integer distance = (Integer)shortestPathService.getShortestPathDistance("Pune", "Hydrabad").getResult();
		
		assertEquals(d, distance);
	}

}
