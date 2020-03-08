package com.airconnect.masterdata.dao;

import java.util.List;

import com.airconnect.common.model.Airline;

public interface AirlineDao {

	public Airline findById(int id);
	public List<Airline> findAllAirlines();
	public List<Airline> findAirlinesByCountryId(int countryId);
	
}
