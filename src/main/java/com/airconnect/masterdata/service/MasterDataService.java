package com.airconnect.masterdata.service;

import java.util.List;

import com.airconnect.common.model.Airline;
import com.airconnect.common.model.Country;
import com.airconnect.common.vo.MasterDataVO;

public interface MasterDataService {

	List<MasterDataVO<Integer, String>> getMasterCountries();
	public List<Airline> fetchAllAirlines();
	public List<MasterDataVO<Integer, String>> fetchAirlinesByCountryId(int countryId);
	public Airline findAirlineById(int id);
	public Airline findAirlineByName(String name);
	public List<Country> fetchAllContries();
	
}