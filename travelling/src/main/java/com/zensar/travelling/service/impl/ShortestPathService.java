package com.zensar.travelling.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.travelling.entity.Cities;
import com.zensar.travelling.entity.LocationKnowldge;
import com.zensar.travelling.repository.IShortestPathRepository;
import com.zensar.travelling.service.IShortestPathService;
import com.zensar.travelling.service.exception.JSONData;
import com.zensar.travelling.service.exception.StatusData;

import ch.qos.logback.core.status.Status;

@Service
public class ShortestPathService implements IShortestPathService {

	@Autowired
	IShortestPathRepository shotestpathrepository;
	
	//@Autowired
	//Graph graph;
	
	static Map<Integer,String> cityMap=new HashMap<>();
	
	@Override
	public JSONData getShortestPathDistance(String sourceCity, String destinationCity) {
		
		System.out.println(sourceCity+" "+destinationCity);
		
		//get all cities		
		List<Cities> allCities = shotestpathrepository.getAllCities();
		
		for(Cities city:allCities)
		{
			Integer id=city.getId();
			String cityName=city.getCity();
			cityMap.put(id, cityName);
		}
		
		System.out.println("cityMap:"+cityMap);
		
		//get all edge information
		
		List<LocationKnowldge> allEdgeData = shotestpathrepository.getAllEdgeData();
		System.out.println("All Edge Data here:"+allEdgeData);
		
		int vertices=cityMap.size();
        System.out.println("--->"+vertices);
        DijkstraAdjacencyMatrix.Graph graph=new DijkstraAdjacencyMatrix.Graph(vertices);
        
      
		
		for(LocationKnowldge edge:allEdgeData)
		{
			Integer sourceCityIndex = shotestpathrepository.getCityIndex(edge.getSourceCity());
			Integer destinationCityIndex= shotestpathrepository.getCityIndex(edge.getDestinationCity());
			Integer weight=edge.getDistance();
		
			
			graph.addEdge(sourceCityIndex,destinationCityIndex, weight);
			System.out.println("addEdge["+ sourceCityIndex+","+destinationCityIndex+","+weight+"]");
		}
		
		
		System.out.println("++==="+sourceCity+" "+destinationCity);
		Integer sCityIndex = shotestpathrepository.getCityIndex(sourceCity);
		Integer dCityIndex= shotestpathrepository.getCityIndex(destinationCity);
		
		System.out.println(sCityIndex+" "+dCityIndex);
		
		int minDistance=graph.dijkstra_GetMinDistances(sCityIndex,dCityIndex);
        System.out.println("Calculated Shortest path distance: "+minDistance);
		
        //graph.dijkstra_GetMinDistances(0,1);
		
        //rate per kilometer
        //int rate=5;
        
		return new JSONData(StatusData.distanceFindSucessMsg,StatusData.distanceFindSucessCode,minDistance);
	}

}
