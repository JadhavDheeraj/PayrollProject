package com.zensar.travelling.service;

import org.springframework.stereotype.Service;

import com.zensar.travelling.service.exception.JSONData;

@Service
public interface IShortestPathService {

	JSONData getShortestPathDistance(String sourceCity, String destinationCity);

}
